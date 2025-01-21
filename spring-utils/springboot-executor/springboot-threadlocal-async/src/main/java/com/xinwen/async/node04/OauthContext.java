package com.xinwen.async.node04;//package com.xinwen.async.node04;
//
//import com.alibaba.ttl.TransmittableThreadLocal;
//import com.alibaba.ttl.TtlCallable;
//import com.alibaba.ttl.TtlCopier;
//import com.alibaba.ttl.spi.TtlEnhanced;
//import com.alibaba.ttl.threadpool.ExecutorServiceTtlWrapper;
//import com.alibaba.ttl.threadpool.agent.TtlAgent;
//import com.xinwen.async.common.LoginVal;
//import org.springframework.lang.NonNull;
//import org.springframework.lang.Nullable;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.WeakHashMap;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Future;
//
///**
// * @author shenlx
// * @description TransmittableThreadLocal
// * @date 2025/2/13 15:20
// */
//public class OauthContext {
//    /**
//     * TransmittableThreadLocal是阿里开源的工具，弥补了InheritableThreadLocal的缺陷，
//     * 在使用线程池等会池化复用线程的执行组件情况下，提供ThreadLocal值的传递功能，解决异步执行时上下文传递的问题。
//     * <p>
//     * TransimittableThreadLocal继承于InheritableThreadLocal，并实现TtlCopier接口，
//     * 它里面只有一个copy方法。所以主要是对InheritableThreadLocal的扩展。
//     * <p>
//     * 在TransimittableThreadLocal中添加holder属性。这个属性的作用就是被标记为具备
//     * 线程传递资格的对象都会被添加到这个对象中。
//     */
//
//    private static final TransmittableThreadLocal<LoginVal> l = new TransmittableThreadLocal<>();
//
//    public static LoginVal get() {
//        return l.get();
//    }
//
//    public static void set(LoginVal loginVal) {
//        l.set(loginVal);
//    }
//
//    public static void clear() {
//        l.remove();
//    }
//
//    /**
//     * TransmittableThreadLocal源码解析
//     * <p>
//     * 要标记一个类，比较容易想到的方式，就是给这个类新增一个Type字段，还有一个方法就是将
//     * 具备这种类型的的对象都添加到一个静态全局集合中。之后使用时，这个集合里的所有值都具备这个标记。
//     */
//
//    //1.holder本身是一个InheritableThreadLocal对象
//    //2.这个holder对象的value是WeakHashMap<TransmittableThreadLocal<Object>,?>
//    //2.1WeekHashMap的value总是null,且不可能被使用。
//    //2.2WeekHasshMap支持value=null
//    private static final InheritableThreadLocal<WeakHashMap<TransmittableThreadLocal<Object>, ?>> holder =
//            new InheritableThreadLocal<WeakHashMap<TransmittableThreadLocal<Object>, ?>>() {
//                @Override
//                protected WeakHashMap<TransmittableThreadLocal<Object>, ?> initialValue() {
//                    return new WeakHashMap<>();
//                }
//
//                /**
//                 *重写了childValue方法，实现上直接将父线程的属性作为子线程的本地变量对象。
//                 */
//                @Override
//                protected WeakHashMap<TransmittableThreadLocal<Object>, ?> childValue(WeakHashMap<TransmittableThreadLocal<Object>, ?> parentValue) {
//                    return new WeakHashMap<>(parentValue);
//                }
//            };
//
//
//    /**
//     * 应用代码是通过TtlExecutors工具类对线程池对象进行包装。工具类只是简单的判断，输入的线程池是否已经被包装过、
//     * 非空校验等，然后返回包装类ExecutorServiceTtlWrapper。根据不同的线程池类型，有不同和的包装类。
//     */
//    @Nullable
//    @Contract(value = "null -> null; !null -> !null", pure = true)
//    public static ExecutorService getTtlExecutorService(@Nullable ExecutorService executorService) {
//        if (TtlAgent.isTtlAgentLoaded() || executorService == null || executorService instanceof TtlEnhanced) {
//            return executorService;
//        }
//        return new ExecutorServiceTtlWrapper(executorService, true);
//    }
//
//    /**
//     * 进入包装类ExecutorServiceTtlWrapper。可以注意到不论是通过ExecutorServiceTtlWrapper#submit方法
//     * 或者是ExecutorTtlWrapper#execute方法，都会将线程对象包装成TtlCallable或者TtlRunnable，用于在真
//     * 正执行run方法前做一些业务逻辑。
//     */
//    @NonNull
//    @Override
//    public <T> Future<T> submit(@NonNull Callable<T> task) {
//        return executorService.submit(TtlCallable.get(task, false, idempotent));
//    }
//
//    /**
//     * 所以，重点的核心逻辑应该是在TtlCallable#call()或者TtlRunnable#run()中。以下以TtlCallable为例，
//     * TtlRunnable同理类似。在分析call()方法之前，先看一个类Transmitter
//     */
//
//
//    public static class Transmitter {
//        /**
//         * 捕获当前线程中的是所有TransimittableThreadLocal和注册ThreadLocal的值。
//         */
//        @NonNull
//        public static Object capture() {
//            return new Snapshot(captureTtlValues(), captureThreadLocalValues());
//        }
//
//        /**
//         * 捕获TransimittableThreadLocal的值,将holder中的所有值都添加到HashMap后返回。
//         */
//        private static HashMap<TransmittableThreadLocal<Object>, Object> captureTtlValues() {
//            HashMap<TransmittableThreadLocal<Object>, Object> ttl2Value =
//                    new HashMap<TransmittableThreadLocal<Object>, Object>();
//            for (TransmittableThreadLocal<Object> threadLocal : holder.get().keySet()) {
//                ttl2Value.put(threadLocal, threadLocal.copyValue());
//            }
//            return ttl2Value;
//        }
//
//        /**
//         * 捕获注册的ThreadLocal的值,也就是原本线程中的ThreadLocal,可以注册到TTL中，在
//         * 进行线程池本地变量传递时也会被传递。
//         */
//        private static HashMap<ThreadLocal<Object>, Object> captureThreadLocalValues() {
//            final HashMap<ThreadLocal<Object>, Object> threadLocal2Value =
//                    new HashMap<ThreadLocal<Object>, Object>();
//            for (Map.Entry<ThreadLocal<Object>, TtlCopier<Object>> entry : threadLocalHolder.entrySet()) {
//                final ThreadLocal<Object> threadLocal = entry.getKey();
//                final TtlCopier<Object> copier = entry.getValue();
//                threadLocal2Value.put(threadLocal, copier.copy(threadLocal.get()));
//            }
//            return threadLocal2Value;
//        }
//
//        /**
//         * 将捕获到的本地变量进行替换子线程的本地变量，并且返回子线程现有的本地变量副本backup。
//         * 用于在执行run/call方法之后，将本地变量副本恢复。
//         */
//        @NonNull
//        public static Object replay(@NonNull Object captured) {
//            final Snapshot capturedSnapshot = (Snapshot) captured;
//            return new Snapshot(replayTtlValues(capturedSnapshot.ttl2Value),
//                    replayThreadLocalValues(capturedSnapshot.threadLocal2Value));
//        }
//
//        /**
//         * 替换TransmittableThreadLocal
//         */
//        @NonNull
//        private static HashMap<TransmittableThreadLocal<Object>, Object> replayTtlValues(@NonNull HashMap<TransmittableThreadLocal<Object>, Object> captured) {
//            // 创建副本backup
//            HashMap<TransmittableThreadLocal<Object>, Object> backup =
//                    new HashMap<TransmittableThreadLocal<Object>, Object>();
//
//            for (final Iterator<TransmittableThreadLocal<Object>> iterator = holder.get().keySet().iterator(); iterator.hasNext(); ) {
//                TransmittableThreadLocal<Object> threadLocal = iterator.next();
//                // 对当前线程的本地变量进行副本拷贝
//                backup.put(threadLocal, threadLocal.get());
//
//                // 若出现调用线程中不存在某个线程变量，而线程池中线程有，则删除线程池中对应的本地变量
//                if (!captured.containsKey(threadLocal)) {
//                    iterator.remove();
//                    threadLocal.superRemove();
//                }
//            }
//            // 将捕获的TTL值打入线程池获取到的线程TTL中。
//            setTtlValuesTo(captured);
//            // 是一个扩展点，调用TTL的beforeExecute方法。默认实现为空
//            doExecuteCallback(true);
//            return backup;
//        }
//
//        private static HashMap<ThreadLocal<Object>, Object> replayThreadLocalValues(@NonNull HashMap<ThreadLocal<Object>, Object> captured) {
//            final HashMap<ThreadLocal<Object>, Object> backup =
//                    new HashMap<ThreadLocal<Object>, Object>();
//            for (Map.Entry<ThreadLocal<Object>, Object> entry : captured.entrySet()) {
//                final ThreadLocal<Object> threadLocal = entry.getKey();
//                backup.put(threadLocal, threadLocal.get());
//                final Object value = entry.getValue();
//                if (value == threadLocalClearMark) threadLocal.remove();
//                else threadLocal.set(value);
//            }
//            return backup;
//        }
//
//        /**
//         * 清除单线线程的所有TTL和TL，并返回清除之气的backup
//         */
//        @NonNull
//        public static Object clear() {
//            final HashMap<TransmittableThreadLocal<Object>, Object> ttl2Value =
//                    new HashMap<TransmittableThreadLocal<Object>, Object>();
//
//            final HashMap<ThreadLocal<Object>, Object> threadLocal2Value =
//                    new HashMap<ThreadLocal<Object>, Object>();
//            for (Map.Entry<ThreadLocal<Object>, TtlCopier<Object>> entry : threadLocalHolder.entrySet()) {
//                final ThreadLocal<Object> threadLocal = entry.getKey();
//                threadLocal2Value.put(threadLocal, threadLocalClearMark);
//            }
//            return replay(new Snapshot(ttl2Value, threadLocal2Value));
//        }
//
//        /**
//         * 还原
//         */
//        public static void restore(@NonNull Object backup) {
//            final Snapshot backupSnapshot = (Snapshot) backup;
//            restoreTtlValues(backupSnapshot.ttl2Value);
//            restoreThreadLocalValues(backupSnapshot.threadLocal2Value);
//        }
//
//        private static void restoreTtlValues(@NonNull HashMap<TransmittableThreadLocal<Object>, Object> backup) {
//            // 扩展点，调用TTL的afterExecute
//            doExecuteCallback(false);
//
//            for (final Iterator<TransmittableThreadLocal<Object>> iterator = holder.get().keySet().iterator(); iterator.hasNext(); ) {
//                TransmittableThreadLocal<Object> threadLocal = iterator.next();
//
//                if (!backup.containsKey(threadLocal)) {
//                    iterator.remove();
//                    threadLocal.superRemove();
//                }
//            }
//
//            // 将本地变量恢复成备份版本
//            setTtlValuesTo(backup);
//        }
//
//        private static void setTtlValuesTo(@NonNull HashMap<TransmittableThreadLocal<Object>, Object> ttlValues) {
//            for (Map.Entry<TransmittableThreadLocal<Object>, Object> entry : ttlValues.entrySet()) {
//                TransmittableThreadLocal<Object> threadLocal = entry.getKey();
//                threadLocal.set(entry.getValue());
//            }
//        }
//
//        private static void restoreThreadLocalValues(@NonNull HashMap<ThreadLocal<Object>, Object> backup) {
//            for (Map.Entry<ThreadLocal<Object>, Object> entry : backup.entrySet()) {
//                final ThreadLocal<Object> threadLocal = entry.getKey();
//                threadLocal.set(entry.getValue());
//            }
//        }
//
//        /**
//         * 快照类，保存TTL和TL
//         */
//        private static class Snapshot {
//            final HashMap<TransmittableThreadLocal<Object>, Object> ttl2Value;
//            final HashMap<ThreadLocal<Object>, Object> threadLocal2Value;
//
//            private Snapshot(HashMap<TransmittableThreadLocal<Object>, Object> ttl2Value,
//                             HashMap<ThreadLocal<Object>, Object> threadLocal2Value) {
//                this.ttl2Value = ttl2Value;
//                this.threadLocal2Value = threadLocal2Value;
//            }
//        }
//    }
//
//    /**
//     * 进入TtlCallable#call()方法。
//     */
//    @Override
//    public V call() throws Exception {
//        Object captured = capturedRef.get();
//        if (captured == null || releaseTtlValueReferenceAfterCall &&
//                !capturedRef.compareAndSet(captured, null)) {
//            throw new IllegalStateException("TTL value reference is released after call!");
//        }
//        // 调用replay方法将捕获到的当前线程的本地变量，传递给线程池线程的本地变量，
//        // 并且获取到线程池线程覆盖之前的本地变量副本。
//        Object backup = replay(captured);
//        try {
//            // 线程方法调用
//            return callable.call();
//        } finally {
//            // 使用副本进行恢复。
//            restore(backup);
//        }
//    }
//}

package spring.boot.algorithm.node02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.algorithm.node02.entity.Item;
import spring.boot.algorithm.node02.entity.Rating;
import spring.boot.algorithm.node02.entity.User;
import spring.boot.algorithm.node02.repository.ItemRepository;
import spring.boot.algorithm.node02.repository.RatingRepository;
import spring.boot.algorithm.node02.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shenlx
 * @description 推荐算法实现
 * @date 2025/2/13 16:43
 */
@Service
public class RecommendationService {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> recommendItems(Long userId) {
        List<Rating> userRatings  = ratingRepository.findByUserId(userId);
        List<User> allUsers  = userRepository.findAll();

        ArrayList<Double> similarities = new ArrayList<>();

        Map<Long,List<Rating>> userRatingsMap=new HashMap<>();
        //计算所有用户与目标得相似度
        for(User user:allUsers){
            if (!(user.getId().equals(userId))){
                List<Rating> otherUserRatings  = ratingRepository.findByUserId(user.getId());
                double similarity  = CosineSimilarity.calculate(userRatings, otherUserRatings);
                similarities.add(similarity);
                userRatingsMap.put(user.getId(),otherUserRatings);
            }
        }
        //找到相似度最高得用户
        int mostSimilarUserId  = similarities.indexOf(Collections.max(similarities));
        List<Rating> mostSimilarUserRatings  = userRatingsMap.get(mostSimilarUserId);

        //推荐该用户没有评分得物品
        Set<Long> recommendedItems  = new HashSet<>();

        for(Rating rating:mostSimilarUserRatings){
            boolean b = userRatings.stream().noneMatch(r -> r.getItemId().equals(rating.getItemId()));
            if(b){
                recommendedItems.add(rating.getItemId());
            }
        }

        //从数据库中获取推荐物品
        List<Item> items=recommendedItems.stream()
                .map(itemId->itemRepository.findById(itemId).orElse(null))
                .collect(Collectors.toList());

        return items;
    }
}

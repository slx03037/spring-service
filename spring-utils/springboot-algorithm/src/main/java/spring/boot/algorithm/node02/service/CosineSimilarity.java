package spring.boot.algorithm.node02.service;

import spring.boot.algorithm.node02.entity.Rating;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author shenlx
 * @description 相似度计算
 * @date 2025/2/13 16:41
 */

/**
 *实现协同过滤算法
 *仅使用基于用户的协同过滤。
 */
public class CosineSimilarity {

    /**
     * 相似度计算
     * 用余弦相似度来计算用户之间的相似度。
     */
    public static double calculate(List<Rating> userRatings, List<Rating> otherUserRatings) {
        Map<Long, Double> userRatingMap = userRatings.stream().collect(Collectors.toMap(Rating::getItemId, Rating::getRating));
        Map<Long, Double> otherUserRatingMap = otherUserRatings.stream().collect(Collectors.toMap(Rating::getItemId, Rating::getRating));

        double dotProduct = 0.0;
        double userMagnitude = 0.0;
        double otherUserMagnitude = 0.0;

        for (Long itemId : userRatingMap.keySet()) {
            if (otherUserRatingMap.containsKey(itemId)) {
                dotProduct += userRatingMap.get(itemId) * otherUserRatingMap.get(itemId);
                userMagnitude += Math.pow(userRatingMap.get(itemId), 2);
                otherUserMagnitude += Math.pow(otherUserRatingMap.get(itemId), 2);
            }
        }

        return dotProduct / (Math.sqrt(userMagnitude) * Math.sqrt(otherUserMagnitude));
    }
}

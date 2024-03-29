package month;

import java.util.*;

class Twitter {

    private final HashMap<Integer, HashSet<Integer>> follow;
    private final HashMap<Integer, Tweet> post;
    private final PriorityQueue<Tweet> queue;
    int timestamp=0;
    class Tweet{
        int tweetId;
        int timestamp;
        Tweet next;
        public Tweet(int tweetId,int timestamp){
            this.tweetId=tweetId;
            this.timestamp=timestamp;
        }
    }
    public Twitter() {
        follow = new HashMap<>();
        post = new HashMap<>();
        queue = new PriorityQueue<>((a, b)->b.timestamp-a.timestamp);
    }
    
    public void postTweet(int userId, int tweetId) {

        if (post.containsKey(userId)){
            Tweet oldTweet = post.get(userId);
            Tweet newTweet = new Tweet(tweetId, timestamp);
            newTweet.next=oldTweet;
            post.put(userId,newTweet);
        }else {
            post.put(userId,new Tweet(tweetId, timestamp));
        }
        timestamp++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        queue.clear();
        List<Integer> ans = new ArrayList<>();
        if (post.get(userId)!=null){
            queue.add(post.get(userId));
        }
        HashSet<Integer> set = follow.get(userId);
        if (set!=null){
            for (Integer id : set) {
                if (post.get(id)!=null){
                    queue.add(post.get(id));
                }
            }
        }

        int n=0;
        while (queue!=null&&queue.size()!=0&&n<10){
            Tweet poll = queue.poll();
            ans.add(poll.tweetId);
            if (poll.next!=null){
                queue.add(poll.next);
            }
            n++;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (follow.containsKey(followerId)){
            follow.get(followerId).add(followeeId);
        }else {
            HashSet<Integer> set = new HashSet<>();
            set.add(followeeId);
            follow.put(followerId,set);
        }

    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> set = follow.get(followerId);
        if (set!=null&&set.contains(followeeId)){
            set.remove(followeeId);
        }

    }
}
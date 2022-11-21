package mititelu.laura;

public class TwitterDemo {

    public static void main(String[] args) {
        TwitterService service = (TwitterService) SecurityProxy.newInstance( new TwitterServiceStub());

        System.out.println(service.getTimeline("testPluralsight"));

        service.postToTimeline("testPluralsight", "Message should not go through");

    }
}

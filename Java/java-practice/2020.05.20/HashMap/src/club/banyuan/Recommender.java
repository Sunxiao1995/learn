package club.banyuan;

import java.util.List;

public interface Recommender<T,L> {

    void addLikes(T Person,L aProject);

    boolean likesBoth(T Person,L oneProject,L twoProject);

    List<L> recommendByPerson(T aPerson);

    List<L> recommendByProject(L aProject);





}


package club.banyuan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PersonalRecommender implements Recommender<String,String>{

   private final HashMap<String,List<String>> Likes = new HashMap<>();

   @Override
   public void addLikes(String aPersonName, String aProjectName) {
      List<String> personLikesList = new LinkedList<>();
      if(Likes.containsKey(aPersonName)){
         personLikesList = Likes.get(aPersonName);
      }
      personLikesList.add(aProjectName);

      Likes.put(aPersonName,personLikesList);
   }

   @Override
   public boolean likesBoth(String aPersonName, String oneProjectName, String twoProjectName) {
      if(!Likes.containsKey(aPersonName)){
         throw new UnknownPersonException("未找到该人");
      }
      List<String> personLikesList = Likes.get(aPersonName);
      return personLikesList.contains(oneProjectName) && personLikesList.contains(twoProjectName);
   }

   @Override
   public List<String> recommendByPerson(String aPersonName) {
      if(!Likes.containsKey(aPersonName)){
         throw new UnknownPersonException("未找到该人");
      }
      return Likes.get(aPersonName);
   }

   @Override
   public List<String> recommendByProject(String aProjectName) {
      boolean projectAreLiked = false;
      List<String> recommendByProject = new LinkedList<>();
      for(List<String> temp : Likes.values()){
         if(temp.contains(aProjectName)){
            temp.remove(aProjectName);
            recommendByProject.addAll(temp);
            projectAreLiked = true;
         }
      }
      if(!projectAreLiked) throw new UnknownPersonException("未找到有人喜欢该项目");
      return recommendByProject;

   }
}

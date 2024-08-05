import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> album = new HashMap<>(); //장르별
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();//장르에 속하는 노래
        
        for(int i = 0 ; i<plays.length; i++){
            if(!album.containsKey(genres[i])){
                album.put(genres[i],plays[i]); //장르별 플레이 횟수
                
                HashMap<Integer,Integer> play = new HashMap<>(); //노래별 플레이 횟수
                play.put(i,plays[i]);           
                music.put(genres[i],play);
            }
            else{
                album.put(genres[i], album.get(genres[i])+plays[i]);
                music.get(genres[i]).put(i,plays[i]);
            }
        }
        
        //장르별 플레이 횟수 정렬
        List<String> keySet = new ArrayList(album.keySet());
        Collections.sort(keySet, (s1, s2) -> album.get(s2) - (album.get(s1)));
        
        //장르에 속한 노래별 필레이 횟수 정렬
        for(String genre:keySet){
            HashMap<Integer,Integer> hm = music.get(genre);
            List<Integer> genre_keys = new ArrayList(hm.keySet());
            
            Collections.sort(genre_keys, (s1, s2) -> hm.get(s2) - (hm.get(s1)));
            
            answer.add(genre_keys.get(0));
            
            if(genre_keys.size() > 1)
                answer.add(genre_keys.get(1));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
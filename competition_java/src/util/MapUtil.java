package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import competition.competitor.Competitor;

public class MapUtil {
    
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByDescendingValue(Map<K, V> map) {

		List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map.entrySet());

		Collections.sort(sortedEntries, new Comparator<Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}
		});

      Map<K, V> result = new LinkedHashMap<>();
      for (Entry<K, V> entry : sortedEntries) {
          result.put(entry.getKey(), entry.getValue());
      }

      return result;
	}
	
    /**
    * sort a groups of competitors by taking the points of competitors
    * @param competitors the group we want to sort
    */
    public static void sortGroups(List<Competitor> competitors){
        Collections.sort(competitors, new Comparator<Competitor>() {
            public int compare(Competitor objet1, Competitor objet2) {
               int libelle1 = objet1.getPoints();
               int libelle2 = objet2.getPoints();
               if (libelle1 > libelle2) return -1;
               else if(libelle1 == libelle2) return 0;
               else return 1;
            }
          });
      }
}
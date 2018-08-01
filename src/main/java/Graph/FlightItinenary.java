package Graph;

import java.util.*;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct
 * the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 */
public class FlightItinenary {
    public static void main(String[] args) {
        String[][] tickets = {
                {"JFK", "SJC"},
                {"MUC", "LHR"},
                {"JFK", "MUC"},
                {"LHR", "SFO"},
                {"SFO", "JFK"}
        };

        System.out.println(findItinerary(tickets));
    }

    public static List<String> findItinerary(String[][] tickets) {
        List<String> itinerary = new ArrayList<>();
        if(tickets == null || tickets.length == 0) return itinerary;

        HashMap<String, ArrayList<String>> ticketsMap = new HashMap<>();
        for(String[] ticket: tickets){
            if(ticketsMap.containsKey(ticket[0])){
                ticketsMap.get(ticket[0]).add(ticket[1]);
            } else {
                ArrayList<String> dests = new ArrayList<>();
                dests.add(ticket[1]);
                ticketsMap.put(ticket[0], dests);
            }
        }

        for (String key : ticketsMap.keySet()) {
            Collections.sort(ticketsMap.get(key));
        }


        dfs("JFK", itinerary, ticketsMap);
        return itinerary;
    }

    static void dfs(String from, List<String> itinenary, HashMap<String, ArrayList<String>> map) {
        if (!map.containsKey(from) || map.get(from).size() == 0) {
            itinenary.add(0, from);
            return;
        }
        while (map.get(from).size() > 0) {
            String to = map.get(from).remove(0);
            dfs(to, itinenary, map);
        }
        itinenary.add(0, from);
    }
}

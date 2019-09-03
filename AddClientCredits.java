package BinarySearchTrees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class AddClientCredits {

	public int offset = 0;
	public Map<String, Integer> clientToCredit = new HashMap<>();
	public NavigableMap<Integer, Set<String>> creditToClients = new TreeMap<>();	//key-credit; value- list of clients
	
	public void insert(String clientID, int c) {
		remove(clientID);
		clientToCredit.put(clientID, c - offset);
		Set<String> set = creditToClients.get(c - offset);
		
		if(set == null) {
			set = new HashSet<>();
			creditToClients.put(c - offset, set);
		}
		set.add(clientID);
	}
	
	public boolean remove(String clientID) {
		Integer clientCredit = clientToCredit.get(clientID);
		if(clientCredit != null) {
			creditToClients.get(clientCredit).remove(clientID);
			if(creditToClients.get(clientCredit).isEmpty()) {
				creditToClients.remove(clientCredit);
			}
			clientToCredit.remove(clientID);
			return true;
		}
		return false;
	}
	
	public int lookup(String clientID) {
		Integer clientCredit = clientToCredit.get(clientID);
		return clientCredit == null ? -1 : clientCredit + offset;
	}
	
	public void addAll(int c) {
		offset += c;
	}
	
	public String max() {
		return creditToClients.isEmpty() ? "" : creditToClients.lastEntry().getValue().iterator().next();
	}
	
	public static void main(String[] args) {

	}
}
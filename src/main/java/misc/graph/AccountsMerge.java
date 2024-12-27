package misc.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<List<String>>> accountsByEmail = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                var accountGroup = accountsByEmail.getOrDefault(account.get(i), new ArrayList<>());
                accountGroup.add(account);
                accountsByEmail.put(account.get(i), accountGroup);
            }
        }

        System.out.println(accountsByEmail);

        Set<String> visited = new HashSet<>();

        List<List<String>> result = new ArrayList<>();

        for (List<String> account : accounts) {
            List<String> accountOut = new ArrayList<>();
            accountOut.add(account.get(0));
            PriorityQueue<String> emails = new PriorityQueue<>();

            Deque<String> stack = new LinkedList<>();
            for (int i = 1; i < account.size(); i++) {
                stack.push(account.get(i));
            }

            while (!stack.isEmpty()) {
                String email = stack.pop();
                if (visited.contains(email)) {
                    continue;
                }
                visited.add(email);
                emails.add(email);

                List<List<String>> accountGroup = accountsByEmail.get(email);
                for (List<String> acc : accountGroup) {
                    for (int i = 1; i < acc.size(); i++) {
                        stack.push(acc.get(i));
                    }
                }
            }
            if (emails.size() > 0) {
                while (!emails.isEmpty()) {
                    accountOut.add(emails.poll());
                }
                result.add(accountOut);
            }
        }

        return result;
    }
}

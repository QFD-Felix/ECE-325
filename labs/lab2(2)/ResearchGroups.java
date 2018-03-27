/**
 * ECE325: Object Oriented Software Design <br />
 * Lab 2: Arrays and Red Black Tree (part 1: Arrays) <br />
 * The ResearchGroup class uses a 2D array to store the names of group members
 */
public class ResearchGroups {
    // TODO: Write your searching and sorting methods here.
	public static void searchMember(String[][] groups, String name) {
        boolean found = false;
        
        for (int group_num = 0; group_num < groups.length; group_num++) {
            String[] group = groups[group_num];

            for (int person_num = 0; person_num < group.length; person_num++) {
                String person = groups[group_num][person_num];

                if (person.equals(name)) {
                    found = true;
                    System.out.printf("found name");
                    if (person_num == 0) {
                        System.out.print("as leader, ");
                    } else {
                        System.out.print("as follower, ");
                    }
                    System.out.printf("group number: %d group position: %d\n", group_num, person_num);
                }
            }
        }

        if (found == false) {
            System.out.printf("Did not find the name");
        }
        return;
    }
	
	public static void heap(String[][] groups, int l) {
		for (int i = 0; i<=l; i++) {
			int k = i;
			
			while (groups[k].length > groups[(k-1)/2].length && k !=0) {
				String[] tmp = groups[k];
				groups [k] = groups[(k-1)/2];
				groups [(k-1)/2] = tmp;
			}
		}
	}
	
	public static void sortGroups(String[][] groups) {
		int length = groups.length-1;
		while(length>0) {
			heap(groups,length);
			
			String[] tmp = groups[0];
			groups [0] = groups[length];
			groups [length] = tmp;
			
			length = length-1;
			
			heap(groups,length);
		}
	}

    public static void main(String[] args) {
        String[][] groups = { {"Bob", "Carol", "Eric", "Matt"},             // 0
                              {"Jim", "Lucy", "Terry", "Brenda", "Ben"},    // 1
                              {"Susan", "Brad", "Jim"},                     // 2
                              {"Sue", "Wendy", "Sam"},                      // 3
                              {"Kate", "Jack", "James", "Sydney"},          // 4
                              {"Mohammad", "Tim", "Kian"},                  // 5
                              {"Emma", "Carol"},                            // 6
                              {"Nick", "Osama", "Harry", "Ben"},            // 7
                              {"Mary", "John", "Ricky"} };                  // 8

        // TODO: Run your searching and sorting methods here.
        
        searchMember(groups,"Bob");
        searchMember(groups,"Jim");
        searchMember(groups,"Susan");
        searchMember(groups,"Kate");
        
        sortGroups(groups);
        
        for (int i=0;i<groups.length;i++) {
            System.out.print("group " + i + ": ");
            for (int j = 0; j < groups[i].length; j++)
                System.out.print(groups[i][j] + " ");
            System.out.println();
        }
    }

}

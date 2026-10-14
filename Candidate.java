class Candidate {
    int rollNo, votes;
    String name, position;

    // Constructor 1
    Candidate(String name, int rollNo, String position, int votes) {
        this.name = name;
        this.rollNo = rollNo;
        this.position = position;
        this.votes = votes;
    }

    // Constructor 2 - Method overloading concept
    Candidate(String name, int rollNo, String position) {
        this(name, rollNo, position, 0);
    }

    void display() {
        System.out.println("Candidate Registered Successfully");
        System.out.println("Candidate Name : " + name.toUpperCase());
        System.out.println("Roll Number    : " + rollNo);
        System.out.println("Position       : " + position.toUpperCase());
        System.out.println("Votes Received : " + votes);
    }

    // Check duplicate candidate names
    boolean isDuplicate(Candidate c) {
        return name.equalsIgnoreCase(c.name);
    }

    // Overloaded method to update votes
    void recordVotes(int votes) {
        this.votes = votes;
    }

    void recordVotes(int votes, int bonusVotes) {
        this.votes = votes + bonusVotes;
    }
}

class Main {
    public static void main(String[] args) {
        Candidate c1 = new Candidate("Ananya", 101, "President", 125);
        Candidate c2 = new Candidate("Rahul", 102, "President", 98);
        Candidate c3 = new Candidate("Ananya", 103, "President", 50);

        System.out.println("===== STUDENT COUNCIL ELECTION =====\n");

        c1.display();
        System.out.println();

        c2.display();
        System.out.println();

        System.out.println("Duplicate Candidate Check:");
        System.out.println("Candidate Name : " + c3.name.toUpperCase());

        if (c1.isDuplicate(c3) || c2.isDuplicate(c3)) {
            System.out.println("Status         : Duplicate Nomination");
        } else {
            System.out.println("Status         : Valid Nomination");
        }

        System.out.println("\n---------- ELECTION RESULTS ----------");

        if (c1.position.equalsIgnoreCase(c2.position)) {
            Candidate winner;

            if (c1.votes > c2.votes) {
                winner = c1;
            } else if (c2.votes > c1.votes) {
                winner = c2;
            } else {
                winner = null;
            }

            System.out.println("Position          : " +
                    c1.position.toUpperCase());

            if (winner != null) {
                System.out.println("Winning Candidate : " +
                        winner.name.toUpperCase());
                System.out.println("Total Votes       : " +
                        winner.votes);
            } else {
                System.out.println("Result            : Election Tie");
                System.out.println("Votes             : " + c1.votes);
            }
        }

        System.out.println("======================================");
    }
}
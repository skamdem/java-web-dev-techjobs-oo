package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {
    private int id;
    public static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // Done: two constructors - one to initialize a unique ID
    public Job() {
        id = nextId++;
    }

    // The second constructor calls the first in order to initialize the 'id' field and initializes other five fields.
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = Objects.isNull(name)?null:(name.equals("")?null:name);
        this.employer = Objects.isNull(employer)?null:(employer.toString().equals("")?null:employer);
        this.location = Objects.isNull(location)?null:(location.toString().equals("")?null:location);
        this.positionType = Objects.isNull(positionType)?null:(positionType.toString().equals("")?null:positionType);
        this.coreCompetency = Objects.isNull(coreCompetency)?null:(coreCompetency.toString().equals("")?null:coreCompetency);
        //System.out.println("Ran with id = "+ id + ", Employer = "+ employer.getValue());
    }

    @Override
    public String toString() {
        if (Objects.isNull(this.name)
        && Objects.isNull(this.employer)
        && Objects.isNull(this.location)
        && Objects.isNull(this.positionType)
        && Objects.isNull(this.coreCompetency)) return "OOPS! This job does not seem to exist.";
        String absent =  "Data not available";
        String aName = !Objects.isNull(this.name)?this.name.toString():absent;
        String anEmployer = !Objects.isNull(this.employer)?this.employer.toString():absent;
        String aLocation = !Objects.isNull(this.location)?this.location.toString():absent;
        String aPositionType = !Objects.isNull(this.positionType)?this.positionType.toString():absent;
        String aCoreCompetency = !Objects.isNull(this.coreCompetency)?this.coreCompetency.toString():absent;
        String str = "\nID: " + id +
                "\nName: " + aName +
                "\nEmployer: " + anEmployer +
                "\nLocation: " + aLocation +
                "\nPosition Type: " + aPositionType +
                "\nCore Competency: " + aCoreCompetency +"\n";
        //return  "\ngo\n"; //Passes testToStringMethodContainsBlankLineBeforeAndAfter()
        /*return "ID: _______\n" +
                "Name: _______\n" +
                "Employer: _______\n" +
                "Location: _______\n" +
                "Position Type: _______\n" +
                "Core Competency: ____\n"; //Passes testToStringMethodContainsLabelForEachField()
        */

        /*
        /*ID:  _______
        Name: _______
        Employer: _______
        Location: _______
        Position Type: _______
        Core Competency:*/
        return str;
    }

    // Done: custom equals and hashCode methods. Consider two Job objects "equal" when their id fields match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Done: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID and id.
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Employer getEmployer() { return employer; }
    public void setEmployer(Employer employer) { this.employer = employer; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
    public PositionType getPositionType() { return positionType; }
    public void setPositionType(PositionType positionType) { this.positionType = positionType; }
    public CoreCompetency getCoreCompetency() { return coreCompetency; }
    public void setCoreCompetency(CoreCompetency coreCompetency) { this.coreCompetency = coreCompetency; }
}

//4. Use unit testing to verify the constructors and equals methods for the Job class.
//5. Use TDD to design and code a custom toString method for the Job class.
//6. Use inheritance to DRY the code within Employer, Location, CoreCompetency, and PositionType.
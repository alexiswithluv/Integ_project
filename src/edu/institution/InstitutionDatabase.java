package edu.institution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InstitutionDatabase {
    private List<EducationalInstitution> institutions;

    public InstitutionDatabase() {
        this.institutions = new ArrayList<>();
    }

    public void addInstitution(EducationalInstitution institution) {
        institutions.add(institution);
    }

    public List<EducationalInstitution> searchByLocation(String location) {
        return institutions.stream()
                .filter(institution -> institution.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }

    public List<EducationalInstitution> searchByCourse(String course) {
        return institutions.stream()
                .filter(institution -> institution.getCourses().contains(course))
                .collect(Collectors.toList());
    }

    public List<EducationalInstitution> searchBySchoolYear(String start, String end) {
        return institutions.stream()
                .filter(institution -> institution.getSchoolYearStart().equalsIgnoreCase(start) && institution.getSchoolYearEnd().equalsIgnoreCase(end))
                .collect(Collectors.toList());
    }
}

package com.example.deaneryoffice;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private List<Group> groups;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        Object attribute = context.getAttribute("groups");

        if (attribute instanceof List) {
            groups = (List<Group>) attribute;
        } else {
            groups = new ArrayList<>();
            Group groupA = new Group("ІА-34");
            groupA.addStudent(new Student("John", "Doe", groupA));
            groupA.addStudent(new Student("Alice", "Johnson", groupA));

            Group groupB = new Group("ІА-33");
            groupB.addStudent(new Student("Jane", "Smith", groupB));

            groups.add(groupA);
            groups.add(groupB);

            context.setAttribute("groups", groups);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchType = request.getParameter("searchType");
        List<Student> searchResults = new ArrayList<>();

        if ("byLastName".equals(searchType)) {
            String lastName = request.getParameter("lastName");
            searchResults = findStudentsByLastName(lastName);
        } else if ("byGroupName".equals(searchType)) {
            String groupName = request.getParameter("groupName");
            searchResults = findStudentsByGroupName(groupName);
        }

        request.setAttribute("searchResults", searchResults);
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("/search.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("/search.jsp").forward(request, response);
    }

    private List<Student> findStudentsByLastName(String lastName) {
        List<Student> studentsWithLastName = new ArrayList<>();
        for (Group group : groups) {
            for (Student student : group.getStudents()) {
                if (student.getLastName().equalsIgnoreCase(lastName)) {
                    studentsWithLastName.add(student);
                }
            }
        }
        return studentsWithLastName;
    }

    private List<Student> findStudentsByGroupName(String groupName) {
        for (Group group : groups) {
            if (group.getName().equalsIgnoreCase(groupName)) {
                return new ArrayList<>(group.getStudents());
            }
        }
        return new ArrayList<>();
    }
}

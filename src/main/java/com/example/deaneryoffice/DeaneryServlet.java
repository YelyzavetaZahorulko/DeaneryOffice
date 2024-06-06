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

@WebServlet("/editGroups")
public class DeaneryServlet extends HttpServlet {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("/editGroups.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addGroup".equals(action)) {
            String groupName = request.getParameter("groupName");
            groups.add(new Group(groupName));
        } else if ("addStudent".equals(action)) {
            String groupName = request.getParameter("groupName");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            addStudentToGroup(groupName, firstName, lastName);
        } else if ("removeStudent".equals(action)) {
            String groupName = request.getParameter("groupName");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            removeStudentFromGroup(groupName, firstName, lastName);
        }

        getServletContext().setAttribute("groups", groups);

        request.setAttribute("groups", groups);
        request.getRequestDispatcher("/editGroups.jsp").forward(request, response);
    }

    private void addStudentToGroup(String groupName, String firstName, String lastName) {
        Group group = findGroupByName(groupName);
        if (group != null) {
            Student student = new Student(firstName, lastName, group);
            group.addStudent(student);
        }
    }

    private void removeStudentFromGroup(String groupName, String firstName, String lastName) {
        Group group = findGroupByName(groupName);
        if (group != null) {
            Student student = findStudentInGroup(group, firstName, lastName);
            if (student != null) {
                group.removeStudent(student);
            }
        }
    }

    private Group findGroupByName(String groupName) {
        return groups.stream().filter(g -> g.getName().equalsIgnoreCase(groupName)).findFirst().orElse(null);
    }

    private Student findStudentInGroup(Group group, String firstName, String lastName) {
        return group.getStudents().stream().filter(s -> s.getFirstName().equalsIgnoreCase(firstName) && s.getLastName().equalsIgnoreCase(lastName)).findFirst().orElse(null);
    }
}

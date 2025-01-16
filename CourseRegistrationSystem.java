
    import java.util.*;

    public class CourseRegistrationSystem {
        private static class Course {
            String courseCode;
            String title;
            String description;
            int capacity;
            int enrolled;

            public Course(String courseCode, String title, String description, int capacity) {
                this.courseCode = courseCode;
                this.title = title;
                this.description = description;
                this.capacity = capacity;
                this.enrolled = 0;
            }

            public boolean isAvailable() {
                return enrolled < capacity;
            }

            public void enrollStudent() {
                if (isAvailable()) {
                    enrolled++;
                }
            }

            public void dropStudent() {
                if (enrolled > 0) {
                    enrolled--;
                }
            }

            @Override
            public String toString() {
                return courseCode + " - " + title + " (" + enrolled + "/" + capacity + ")\n" + description;
            }
        }

        private static class Student {
            String studentID;
            String name;
            List<Course> registeredCourses;

            public Student(String studentID, String name) {
                this.studentID = studentID;
                this.name = name;
                this.registeredCourses = new ArrayList<>();
            }

            public void registerCourse(Course course) {
                if (!registeredCourses.contains(course) && course.isAvailable()) {
                    registeredCourses.add(course);
                    course.enrollStudent();
                    System.out.println("Successfully registered for: " + course.title);
                } else {
                    System.out.println("Unable to register for: " + course.title + " (Full or already registered)");
                }
            }

            public void dropCourse(Course course) {
                if (registeredCourses.contains(course)) {
                    registeredCourses.remove(course);
                    course.dropStudent();
                    System.out.println("Successfully dropped: " + course.title);
                } else {
                    System.out.println("You are not registered for: " + course.title);
                }
            }

            public void listRegisteredCourses() {
                if (registeredCourses.isEmpty()) {
                    System.out.println("No courses registered.");
                } else {
                    System.out.println("Registered courses:");
                    for (Course course : registeredCourses) {
                        System.out.println(course);
                    }
                }
            }
        }

        private List<Course> courses;
        private Student student;

        public CourseRegistrationSystem() {
            courses = new ArrayList<>();
            loadCourses();
            student = new Student("S001", "John Doe");
        }

        private void loadCourses() {
            courses.add(new Course("CS101", "Introduction to Computer Science", "Learn the basics of computer science.", 3));
            courses.add(new Course("MATH201", "Calculus I", "An introduction to calculus.", 2));
            courses.add(new Course("PHY101", "Physics Fundamentals", "Basic principles of physics.", 2));
        }

        public void listCourses() {
            System.out.println("Available courses:");
            for (Course course : courses) {
                System.out.println(course);
            }
        }

        public Course findCourseByCode(String courseCode) {
            for (Course course : courses) {
                if (course.courseCode.equalsIgnoreCase(courseCode)) {
                    return course;
                }
            }
            return null;
        }

        public void start() {
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\nWelcome to the Course Registration System");
                System.out.println("1. List all courses");
                System.out.println("2. Register for a course");
                System.out.println("3. Drop a course");
                System.out.println("4. View registered courses");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        listCourses();
                        break;
                    case 2:
                        System.out.print("Enter course code to register: ");
                        String registerCode = scanner.nextLine();
                        Course registerCourse = findCourseByCode(registerCode);
                        if (registerCourse != null) {
                            student.registerCourse(registerCourse);
                        } else {
                            System.out.println("Course not found.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter course code to drop: ");
                        String dropCode = scanner.nextLine();
                        Course dropCourse = findCourseByCode(dropCode);
                        if (dropCourse != null) {
                            student.dropCourse(dropCourse);
                        } else {
                            System.out.println("Course not found.");
                        }
                        break;
                    case 4:
                        student.listRegisteredCourses();
                        break;
                    case 5:
                        System.out.println("Exiting the system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);

            scanner.close();
        }

        public static void main(String[] args) {
            CourseRegistrationSystem system = new CourseRegistrationSystem();
            system.start();
        }
    }



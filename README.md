# Activity 1 - Layered Project + SQLite (Register / Login / Logout)

Roles used: CASHIER and CUSTOMER (from Section 2 of your proposal; ADMIN is added in Activity 2). If your instructor insists on TEACHER/STUDENT for this activity only, edit the two role strings in `MainMenu.selectRole()`.

## Package layout
- `dao`: DatabaseConnection.java, UserDao.java
- `model`: User.java (Java record)
- `ui`: MainMenu.java
- `Main.java`: entry point

## How to pass (checklist)
- [ ] Packages dao / model / ui + Main.java exist
- [ ] pom.xml has the sqlite-jdbc dependency
- [ ] users table has id, username, password, roles, status
- [ ] Register saves with status PENDING and a chosen role
- [ ] Login checks username + password in the database
- [ ] Logout / Exit works
- [ ] All SQL uses PreparedStatement
- [ ] Public GitHub link submitted

## Test run
1. Run Main > 1 (Register) > username `juan`, password `1234`, role 2.
2. Choose 2 (Login) with the same credentials > you see Role and Status PENDING > 1 (Logout) > 3 (Exit).
3. Try a wrong password to see "Invalid username or password."

## One-time setup (IntelliJ IDEA)
1. Make sure your System Proposal is marked APPROVED/RECORDED by your instructor.
2. File > Open > select this folder. Wait for Maven to download `sqlite-jdbc` (pom.xml). Set Project SDK to Java 17 or higher (records need 16+).
3. Right-click `Main.java` > Run. A `students.db` file appears in the project root.
4. Install DB Browser for SQLite (or SQLiteStudio) to open `students.db` for the database screenshot.

## Push to GitHub (public repo)
1. Create a new PUBLIC repository on GitHub (e.g. `cinepass-oop`).
2. In the IntelliJ terminal:
   ```
   git init
   git add .
   git commit -m "Activity message here"
   git branch -M main
   git remote add origin https://github.com/YOUR_USERNAME/cinepass-oop.git
   git push -u origin main
   ```
3. Check the repo in a private/incognito window to confirm it is public.
4. Paste the repo link in Google Classroom.
   Tip: for each new activity, copy the new files over the same repo and commit again (one repo, new commit per activity).


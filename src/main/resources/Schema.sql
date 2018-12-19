CREATE TABLE Roles (
    Roles_Id int  PRIMARY KEY,
    Roles_Name varchar(10),
    Is_Deleted  bit
);

CREATE TABLE Users (
    User_Id int  IDENTITY PRIMARY KEY,
    User_Password varchar(10) ,
    User_Name varchar(25) ,
    User_Email varchar(40),
    User_City varchar(40),
    Roles_Id int,
    Is_Deleted bit
);

--is deleted ?
--auditing


CREATE TABLE Event (
    Event_Id int IDENTITY PRIMARY KEY,
    Event_Name varchar(50) ,
    eventdate DATE ,
    Event_Capacity int,
    eventcity varchar(40),
    Organizer_Id int,
    Is_Deleted bit,
    Is_Approved bit,
    counter int
    );

CREATE TABLE Ticket (
    Ticket_Id int IDENTITY PRIMARY KEY,
    Event_Id int,
    Attender_Id int,
    Cancelled bit,
    Attended bit
);

CREATE TABLE Review (
    Review_Id int  PRIMARY KEY,
    Ticket_Id int,
    Review_Comment varchar(50),
    Is_Deleted bit

);

ALTER TABLE Users ADD FOREIGN KEY (Roles_Id) REFERENCES Roles(Roles_Id);
ALTER TABLE Event ADD FOREIGN KEY (Organizer_Id) REFERENCES Users(User_Id);
ALTER TABLE Ticket ADD FOREIGN KEY (Event_Id) REFERENCES Event(Event_Id);
ALTER TABLE Ticket ADD FOREIGN KEY (Attender_Id) REFERENCES Users(User_Id);
ALTER TABLE Review ADD FOREIGN KEY (Ticket_Id) REFERENCES Ticket(Ticket_Id);

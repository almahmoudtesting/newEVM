INSERT INTO Roles ( Roles_Id, Roles_Name,Is_Deleted)
VALUES (0,'Admin','0'),(1,'User','0'),(2,'Organizer','0');

--UPDATE Users
--SET firstname = 'Abdullah', lastname= 'Alharbi'
--WHERE userid = 1223344551;

INSERT INTO Users (User_Password , User_Name,User_Email,Is_Deleted,User_City,Roles_Id)
VALUES ('Muhannad','Alomaran','example@example.com','0', 'Riyadh',1);

INSERT INTO Users (User_Password,User_Name,User_Email,Is_Deleted,User_City,Roles_Id)
VALUES ('Ali','Alali','A@e.com','0','Jeddah',2),('Waleed','Bassam','n@e.com','0','Jeddah',2);

INSERT INTO Event (Event_Name,eventdate,Event_Capacity,Is_Deleted,Is_Approved, eventcity,Organizer_Id,counter)
VALUES ('Jinadriah','2018-11-11',300,'0','0','Riyadh',2,0);

--INSERT INTO Event (Event_Id,Event_Name,eventdate,Event_Capacity,Is_Deleted,Is_Approved,eventcity)
--VALUES (55,'EID','2018-11-11',400,'0','0','Khobar');

INSERT INTO Ticket (Event_Id,Attender_Id, Cancelled,Attended)
VALUES (1,1,'0','0');
--DELETE from Users
--WHERE firstname='Muhannad';

INSERT INTO Review ( Review_Id,Ticket_Id, Review_Comment, Is_Deleted)
VALUES (1,1,'Hello','0');
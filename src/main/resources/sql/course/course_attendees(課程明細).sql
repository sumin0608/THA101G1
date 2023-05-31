CREATE TABLE course_attendees (
  attendId INT AUTO_INCREMENT,
  courseId INT,
  memberId INT(10),
  attendTime TIMESTAMP,
  status INT,
  reason TEXT,
  paymentStatus INT,
  commentStatus INT,
  PRIMARY KEY (attendId)
);

INSERT INTO course_attendees (courseId, memberId, attendTime, status, reason, paymentStatus, commentStatus)
VALUES 
  (1, 2, CURRENT_TIMESTAMP, 1, '參加原因1', 1, 0),
  (1, 3, CURRENT_TIMESTAMP, 1, '參加原因2', 1, 0),
  (2, 4, CURRENT_TIMESTAMP, 1, '參加原因3', 0, 0);

SELECT * FROM THA101G1.course_attendees;
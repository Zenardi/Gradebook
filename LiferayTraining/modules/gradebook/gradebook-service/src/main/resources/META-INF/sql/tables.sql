create table Gradebook_Assignment (
	uuid_ VARCHAR(75) null,
	assignmentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title STRING null,
	description VARCHAR(75) null,
	dueDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table Gradebook_Submission (
	submissionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	assignmentId LONG,
	studentId LONG,
	submitDate DATE null,
	submissionText VARCHAR(75) null,
	comment_ VARCHAR(75) null,
	grade INTEGER
);
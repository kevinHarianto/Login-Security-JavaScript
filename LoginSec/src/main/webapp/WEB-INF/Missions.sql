use java3;

create table missiontable (
	missionId int primary key auto_increment,
	missionName varchar(50) not null unique,
  missionType varchar(50) not null,
  missionDescription varchar(400),
  difficulty int not null,
  completed boolean not null,
  assignedTo varchar(50)
);

insert into missiontable values
(1, 'Send pizza', 'Deliver', 'Send a cheese pizza to Superman, get tips.', 88, false, 'Hulk'),
(2, 'Fight bat', 'Fight', 'Go beat Batman on butt 100 times, then stop.', 55, false, 'Spider-Man'),
(3, 'Ride bike', 'Ride', 'Ride a bike with Wonder Woman, enjoy.', 79, false, 'Iron Man'),
(4, 'Build robot', 'Build', 'Build a robot with The Flash, have fun.', 34, false, 'Captain America'),
(5, 'Crash house', 'Destroy', 'Destroy Green Lantern house, for no reason.', 62, false, 'Thor'),
(6, 'Let go', 'Evacuate', 'Evacuate Jean Grey from fire, cool him.', 27, false, 'Black Widow'),
(7, 'Save life', 'Rescue', 'Help Supergirl with her assignment, about Java.', 93, false, 'Ant-Man'),
(8, 'Knock him', 'Eliminate', 'Remove Hawkman from the team, he''s drunk.', 46, false, 'Hulkbuster'),
(9, 'Gather bugs', 'Collect', 'Clean up Metamorpho''s front-yard, get paid.', 14, false, 'Doctor Strange'),
(10, 'Give gum', 'Supply', 'Feed Green Arrow some gum, he likes it.', 58, false, 'Hawkeye'),
(11, 'Fix car', 'Repair', 'Install snow tires to Atom''s car, its winter.', 81, false, 'Winter Soldier'),
(12, 'Protect dog', 'Defense', 'Keep Cyclop''s dog away cat, it may bite.', 37, false, 'Falcon'),
(13, 'Arrest him', 'Capture', 'Take Megneto to washroom, he belongs to there.', 72, false, 'War Machine'),
(14, 'Seiz wolf', 'Hijack', 'Take Wolverine off logging, teach him a carpenter.', 85, false, 'Loki');




create database if not exists TP2;
use TP2;

drop table if exists local;
create table local(
	id_local int(11) not null,
    nom_local varchar(45) not null,
    primary key(id_local),
    index idxlocal (nom_local ASC)
    )engine=InnoDB;

drop table if exists usager;
create table usager(
	id_usager int(11) not null,
    nom_usager varchar(45) not null,
    prenom_usager varchar(45) not null,
    telephone_usager int null,
    id_local int(11) null,
    constraint pk_id_usager primary key (id_usager),
    constraint fk_tlb_local_idlocal2_idx foreign key(id_local) references local (id_local)
    )engine=innodb;

drop table if exists fabricant;
create table fabricant (
	id_fabricant int(11) not null,
    nom_fabricant varchar(45) not null,
    index idxNomFabricant (nom_fabricant ASC),
    constraint pk_id_fabricant primary key (id_fabricant)
) engine=innodb;

drop table if exists poste;
create table poste(
	id_poste int(11) not null,
	desc_poste varchar(45) null,
	desc_processeur varchar(45) null,
	nb_ram_mo varchar(45) null,
	tail_disque_giga int(11) null,
	id_fabricant int(11) null,
	id_local int(11) null,
    constraint pk_id_poste primary key(id_poste),
    constraint fk_tbl_fabricant_idx foreign key (id_fabricant) references fabricant (id_fabricant),
    constraint fk_tbl_local_id_local1_idx foreign key (id_local) references local (id_local)
)engine=innodb;

drop table if exists editeur;
create table editeur (
	id_editeur int(11) not null,
    nom_editeur varchar(45) not null,
    constraint pk_id_editeur primary key (id_editeur),
    Index idxNomEditeur (nom_editeur ASC)
)engine=innodb;

drop table if exists logiciel;
create table logiciel (
	id_logiciel int(11) not null,
    nom_logiciel varchar(45) not null,
    nb_licence int(11) null,
    id_editeur int(11) not null,
    constraint pk_id_logiciel primary key (id_logiciel),
    constraint fk_id_editeur_idx foreign key (id_editeur) references editeur (id_editeur)
) engine=innodb;


drop table if exists usager_has_tbl_poste;
create table usager_has_tbl_poste(
	id_usager int(11) not null,
    id_poste int(11) not null,
    constraint pk_id_usager_id_poste primary key (id_usager , id_poste),
    constraint fk_tbl_poste_id_poste2_idx foreign key (id_poste) references poste (id_poste),
    constraint fk_tbl_usager_id_usager1_idx foreign key (id_usager) references usager(id_usager)
)engine=innodb;

drop table if exists poste_has_tbl_logiciel;
create table poste_has_tbl_logiciel(
	id_poste int(11) not null,
    id_logiciel int(11) not null,
    constraint pk_id_poste_id_logiciel primary key (id_poste, id_logiciel),
    constraint fk_tbl_logiciel_id_logiciel1_idx foreign key (id_logiciel) references logiciel (id_logiciel),
    constraint fk_tbl_poste_id_poste1_idx foreign key (id_poste) references poste (id_poste)
    )engine=innodb;
    
drop table if exists peripherique;
create table peripherique(
	id_fabricant int(11) not null,
    nom_peripherique varchar(45) not null,
    id_poste int(11) null,
    id_fabricant int(11) not null,
    index idxPeripherique (nom_peripherique ASC),
    constraint pk_id_fabricant primary key (id_fabricant),
    constraint fk_tlb_poste_id_poste3_idx foreign key (id_poste) references poste(id_poste),
    constraint fk_tbl_fabricant_id_fabricant_idx foreign key (id_fabricant) references fabricant (id_fabricant)
    )engine=innodb;
    
INSERT INTO editeur 
	VALUES (1,'Adobe'),(2,'Microsoft'),(3,'Canonical'),(4,'Apple'),(5,'Symantec'),(6,'Red Hat'),(7,'Avast'),(8,'Sage 50'),(9,'Fondation Apache'),(10,'Oracle'),
    (11,'Logiciel libre'),(12,'VM Ware');

INSERT INTO fabricant 
	VALUES (1,'HP'),(2,'Lenovo'),(3,'Apple'),(4,'Acer'),(5,'Intel'),(10,'Tincidunt Congue Turpis Corporation'),(11,'Purus Consulting'),(12,'Pede Nunc Inc.'),
    (13,'Vivamus Company'),(14,'Quisque Libero Associates'),(15,'Magna Nam Limited'),(16,'Mollis Dui Incorporated'),(17,'Aliquam Iaculis Lacus Industries'),
    (18,'A Enim PC'),(19,'Auctor Quis Tristique Corp.'),(20,'Vitae Odio Sagittis Corporation'),(21,'Ultricies Foundation'),(22,'Eu Lacus LLP'),(23,'Nam Incorporated'),
    (24,'Nisl LLP'),(25,'Viverra Maecenas Foundation'),(26,'Molestie Pharetra LLP'),(27,'Euismod Mauris Eu Corp.'),(28,'Id Erat Etiam Foundation'),
    (29,'Cras Convallis Convallis Company'),(30,'Duis Cursus Corp.'),(31,'Proin Institute'),(32,'Nulla Cras Eu Incorporated'),(33,'Urna Associates'),(34,'Velit Aliquam PC'),
    (35,'Malesuada Foundation'),(36,'Vel Convallis In Inc.'),(37,'Phasellus Dapibus Quam Limited'),(38,'Donec Fringilla Donec Company'),(39,'Vitae Limited'),
    (40,'Facilisis Incorporated'),(41,'Id Ante Nunc Industries'),(42,'Eu Metus In Inc.'),(43,'Euismod Corporation'),(44,'Erat Nonummy Ultricies Incorporated'),
    (45,'Posuere Cubilia Curae; Industries'),(46,'Enim LLP'),(47,'Tincidunt Adipiscing Corp.'),(48,'Mauris Vestibulum Limited'),(49,'Lacinia Sed Congue LLP'),
    (50,'Pede Sagittis Augue Ltd'),(51,'Erat Company'),(52,'Erat PC'),(53,'Ut Nulla Cras Incorporated'),(54,'Amet Metus Limited'),(55,'Integer Corporation'),
    (56,'Nec Inc.'),(57,'Molestie Arcu Sed Corp.'),(58,'Nisi Consulting'),(59,'Mus Aenean Limited'),(60,'Augue Malesuada Malesuada Incorporated'),(61,'Nec Malesuada Ltd'),
    (62,'Lacus Nulla Tincidunt Consulting'),(63,'In Condimentum Donec LLP'),(64,'Vel Arcu Eu Company'),(65,'Nunc In At Ltd'),(66,'Elementum Lorem Ut Corp.'),
    (67,'Natoque Ltd'),(68,'Nec Diam Duis PC'),(69,'Justo Sit Corp.'),(70,'Ullamcorper Duis At Industries'),(71,'Amet Ornare Industries'),(72,'Eget Ltd'),
    (73,'Tellus Associates'),(74,'Orci Industries'),(75,'Orci Tincidunt Corp.'),(76,'Mollis PC'),(77,'Accumsan Sed Incorporated'),(78,'Id Libero LLC'),
    (79,'Nec Leo Morbi Industries'),(80,'Mauris LLC'),(81,'Sagittis Augue Eu Corporation'),(82,'Erat Neque Non PC'),(83,'Dis Company'),(84,'Arcu Institute'),
    (85,'Fermentum PC'),(86,'Non Arcu Limited'),(87,'Nam Industries'),(88,'Sit Amet LLP'),(89,'Integer LLC'),(90,'In Condimentum PC'),(91,'Nisi Ltd'),
    (92,'Dictum Cursus Nunc Industries'),(93,'Odio Phasellus At LLC'),(94,'Est Congue A Associates'),(95,'Nec Ante Ltd'),(96,'Donec Nibh PC'),(97,'Quisque Ltd'),
    (98,'Diam At Pretium Institute'),(99,'Erat Volutpat Company'),(100,'Feugiat Associates'),(101,'Ut Molestie Industries'),(102,'Ornare Elit Elit Limited'),
    (103,'Dui Suspendisse Ac Ltd'),(104,'Mollis Integer Tincidunt Incorporated'),(105,'Ac Corporation'),(106,'Fermentum Associates'),(107,'Sit Amet LLC'),
    (108,'Nulla Magna Company'),(109,'Nunc Ac Sem LLP');

INSERT INTO local 
	VALUES (1,'P-409'),(2,'P-418'),(3,'P-309'),(4,'P-308'),(5,'P-310'),(6,'P-416'),(7,'P-210'),(8,'P-211'),(9,'P-212'),(10,'P213');

INSERT INTO logiciel 
	VALUES (1,'Libre Office',100,6),(2,'Microsoft Office 2010',24,2),(3,'ITune',100,4),(4,'Avast',200,7),(5,'Simple comptable',24,8),(6,'SQL Serveur',48,2),
    (7,'Client Oracle 11g (win64_11gR2_client)',48,11),(8,'Oracle Mysql serveur',0,11),(9,'Red Hat serveur 12',48,6),(11,'AdobeReader X',200,1),(12,'Windows 7',200,2),
    (13,'FileZilla Client 3.5.3',0,11),(14,'Firefox 12.0',0,11),(15,'Flash Player 11.0',200,1),(16,'MySQL Workbench 6 CE',0,11),(17,'Open Office 3.3',0,11),
    (18,'Visual Studio 2010',48,2),(19,'WAMP server 2.0i',0,11),(20,'Ubuntu 14.04',0,3),(21,' OS X 10.9 Mavericks',24,4),(22,'VM Ware Workstation 10',48,12);

alter table usager modify telepone_usager varchar(45);

INSERT INTO usager 
	VALUES (1,'Duchesneau','Jean-Pierre','1-418-656-6600',6),
			(2,'Berrier','Goerge','1-418-656-6600',6),(3,'Roy','Claude','1-418-656-0000',6),
			(4,'Parent','Alain','1-418-656-0000',6),(5,'Laflamme','Robert','1-418-656-0000',6),
			(6,'Besse','Camille','1-418-656-0000',6),(7,'Filiatreault','Karine','1-418-656-0000',6),
			(8,'Boumso','André','1-418-656-0000',6),(9,'Awdé','Ali','1-418-656-0000',6),(100,'Gilbert','Nathalie','1-418-656-0000',7),
			(101,'Ricard','Serge','1-418-656-0000',7),(102,'Gosselin','Sylvie','1-418-656-0000',7),(103,'Fiset','Marc','1-418-656-0000',7),
			(104,'Ducharme','Renée','1-418-656-0000',7),(105,'Ratté','Sylvie','1-418-656-0000',7),(106,'Massé','Odette','1-418-656-0000',7),
			(1000,'Rasmussen','Hiroko','1-306-317-9668',1),(1001,'Hall','Iliana','1-148-407-7768',1),(1002,'Glenn','Suki','1-464-535-8426',1),
			(1003,'Hernandez','David','1-252-873-1576',1),(1004,'Forbes','Piper','1-208-468-0258',1),(1005,'Gould','Leila','1-867-963-4130',1),
            (1006,'Shannon','Leroy','1-944-144-2566',1),(1007,'Barnett','Lee','1-121-653-3903',1),(1008,'Reilly','Wyoming','1-254-861-3062',1),
            (1009,'Saunders','Cally','1-689-766-8685',1),(1010,'Wagner','Tanisha','1-233-877-6750',1),(1011,'Turner','Cole','1-387-794-3559',1),
            (1012,'Kirkland','Nathaniel','1-550-994-2808',1),(1013,'Barron','Yoshio','1-537-706-3847',1),(1014,'Craft','Nicholas','1-907-539-8109',1),
            (1015,'Day','Cora','1-748-246-7140',1),(1016,'Weber','Prescott','1-927-941-1713',1),(1017,'Mccall','Emerald','1-995-990-2768',1),
            (1018,'Pena','Kennan','1-605-164-9441',1),(1019,'Mitchell','Maxine','1-959-422-7561',1),(1020,'Scott','Coby','1-844-709-3266',1),
            (1021,'Mclaughlin','Igor','1-883-216-8472',1),(1022,'Martin','Risa','1-946-307-4541',1),(1023,'Campbell','Ina','1-712-719-8563',1),
            (1024,'Reilly','Eliana','1-305-208-2993',1),(1025,'Newman','Galvin','1-233-908-4203',2),(1026,'Hull','Nissim','1-742-990-0945',2),
            (1027,'Rasmussen','Margaret','1-651-136-1290',2),(1028,'Bray','Kerry','1-231-723-4971',2),(1029,'Davidson','Reece','1-933-621-3588',2),
            (1030,'Kemp','Roth','1-876-526-0141',2),(1031,'Rowland','Jael','1-548-763-6332',2),(1032,'Malone','Belle','1-181-195-3183',2),
            (1033,'Hendrix','Hector','1-298-364-7331',2),(1034,'Mendez','Susan','1-124-116-2284',2),(1035,'Rosario','Emerson','1-149-104-5111',2),
            (1036,'Leon','Serina','1-339-219-7081',2),(1037,'Riddle','Hyatt','1-835-626-7573',2),(1038,'Bates','Haley','1-352-129-9180',2),
            (1039,'Hahn','Rhonda','1-493-727-4941',2),(1040,'Santana','Kennan','1-732-922-2804',2),(1041,'Wilder','Signe','1-877-214-5267',2),
            (1042,'Holman','Lev','1-143-884-1358',2),(1043,'Mcintosh','Philip','1-759-767-2459',2),(1044,'Sykes','Kylie','1-985-247-1801',2),
            (1045,'Burke','Lewis','1-231-388-9330',2),(1046,'Kent','Kaye','1-708-982-9129',2),(1047,'Barr','Lilah','1-578-722-0273',2),
            (1048,'Bridges','Ora','1-499-197-1785',2),(1049,'Rivera','Shelley','1-299-827-9281',2),(1050,'May','Derek','1-948-157-0026',3),
            (1051,'Sellers','Jordan','1-567-848-6853',3),(1052,'Floyd','Henry','1-204-771-7447',3),(1053,'Cardenas','Britanney','1-201-739-6444',3),
            (1054,'Swanson','Sonia','1-698-434-4014',3),(1055,'Kent','Guinevere','1-581-468-8203',3),(1056,'Hubbard','Igor','1-187-963-4115',3),
            (1057,'Thomas','Lacey','1-280-310-5240',3),(1058,'Giles','Kevyn','1-598-218-8475',3),(1059,'Glover','Amal','1-822-206-5395',3),
            (1060,'Potter','Kessie','1-260-271-9633',3),(1061,'Pace','Norman','1-516-281-2550',3),(1062,'Hess','Andrew','1-588-970-9129',3),
            (1063,'Oliver','Vaughan','1-559-852-4089',3),(1064,'Casey','Jenna','1-813-448-2672',3),(1065,'Harper','Ivy','1-617-899-9191',3),
            (1066,'Morse','Andrew','1-989-525-3645',3),(1067,'Hunter','Laura','1-775-655-4398',3),(1068,'Wyatt','Ori','1-488-505-3545',3),
            (1069,'Jacobson','Abel','1-836-690-4379',3),(1070,'Delgado','Alika','1-927-969-5844',3),(1071,'Rojas','Glenna','1-403-578-3805',3),
            (1072,'Pierce','Tatyana','1-276-257-9019',3),(1073,'Burris','Ciara','1-381-659-4484',3),(1074,'Russell','Ryan','1-462-524-3231',3),
            (1075,'Rosales','Cole','1-804-249-9655',4),(1076,'Delaney','Brenna','1-506-133-2199',4),(1077,'Yang','Clio','1-905-984-7452',4),
            (1078,'Hampton','Helen','1-275-923-0361',4),(1079,'Banks','Abigail','1-525-797-6781',4),(1080,'Porter','Ila','1-826-996-0013',4),
            (1081,'Grimes','Donovan','1-406-354-1625',4),(1082,'Snyder','Ryan','1-800-226-2125',4),(1083,'Burgess','Cora','1-557-559-0149',4),
            (1084,'Copeland','Daria','1-667-363-2986',4),(1085,'Swanson','Dexter','1-626-976-5921',4),(1086,'Richards','Quon','1-430-811-8373',4),
            (1087,'Nolan','Keith','1-396-708-0421',4),(1088,'Blake','Bernard','1-563-908-0846',4),(1089,'Mccray','Francis','1-202-546-5751',4),
            (1090,'Stevens','Nita','1-903-615-2956',4),(1091,'Blankenship','Kimberley','1-301-475-9453',4),(1092,'Peters','Murphy','1-882-500-6277',4),
            (1093,'Long','Lila','1-581-385-3872',4),(1094,'Parsons','Dieter','1-582-349-3373',4),(1095,'Stevenson','Kylee','1-525-657-1859',4),
            (1096,'Hanson','Ebony','1-823-185-7050',4),(1097,'Buck','Edward','1-616-415-2385',4),(1098,'Bean','Griffin','1-937-746-0989',4),
            (1099,'Holman','Tate','1-776-590-9971',4);
            
# Specifications sur l'ordre d'insertion des éléments
INSERT INTO poste (id_poste, id_fabricant, desc_poste, desc_processeur, nb_ram_mo, tail_disque_giga)
	VALUES 
    (1,1,'Ordinateur de bureau HP 700-329','Intel core i7 4960X','32000',2000),
    (2,1,'Ordinateur de bureau HP 700-329','Intel core i7 4960X','32000',2000),
    (3,1,'Ordinateur de bureau HP 700-329','Intel core i7 4960X','32000',2000),
    (4,1,'Ordinateur de bureau HP 700-329','Intel core i7 4960X','32000',2000),
    (5,1,'Ordinateur de bureau HP 700-329','Intel core i7 4960X','32000',2000),
    (6,1,'Ordinateur de bureau HP 700-329','Intel core i7 4960X','32000',2000),
    (7,1,'Ordinateur de bureau HP 700-329','Intel core i7 4960X','32000',2000),
    (8,1,'Ordinateur de bureau HP 700-329','Intel core i7 4960X','32000',2000),
    (9,1,'Ordinateur de bureau HP 700-329','Intel core i7 4960X','32000',2000),
    (10,1,'Ordinateur de bureau HP 700-329','Intel core i7 4960X','32000',2000),
    (100,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (101,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (102,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (103,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (104,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (105,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (106,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (107,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (108,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (109,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (110,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (111,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (112,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (113,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (114,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (115,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (116,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (117,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (118,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (119,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (120,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (121,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (122,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (123,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (124,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (125,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (126,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (127,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (128,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (129,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (130,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (131,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (132,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (133,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (134,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (135,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (136,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (137,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (138,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (139,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (140,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (141,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (142,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (143,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (144,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (145,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (146,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (147,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (148,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (149,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (150,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (151,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (152,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (153,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (154,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (155,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (156,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (157,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (158,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (159,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (160,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (161,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (162,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (163,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (164,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (165,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (166,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (167,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (168,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (169,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (170,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (171,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (172,1,'HP Beats Special Edition 23-n010 All-in-One D','Intel core i5 2400','8000',1000),
    (173,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),(174,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),
    (175,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),(176,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),
    (177,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),(178,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),
    (179,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),(180,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),
    (181,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),(182,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),
    (183,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),(184,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),
    (185,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),(186,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),
    (187,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),(188,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),
    (189,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),(190,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),
    (191,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),(192,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),
    (193,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),(194,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),
    (195,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),(196,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),
    (197,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),(198,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000),
    (199,3,'Mac Pro  ','Intel Xéon E5  ','12000',1000);  

INSERT INTO peripherique (id_peripherique, nom_peripherique, id_poste)
	VALUES (1,'Écran Samsung 19 po.',1),(3,'Écran Samsung 19 po.',2),(4,'Écran Samsung 19 po.',3),(5,'Écran Samsung 19 po.',4),(6,'Écran Samsung 19 po.',5),
    (7,'Écran Samsung 19 po.',6),(8,'Écran Samsung 19 po.',7),(9,'Écran Samsung 19 po.',8),(10,'Écran Samsung 19 po.',9),(11,'Écran Samsung 19 po.',100),
    (12,'Écran Samsung 19 po.',101),(13,'Écran Samsung 19 po.',102),(14,'Écran Samsung 19 po.',103),(15,'Écran Samsung 19 po.',104),(16,'Écran Samsung 19 po.',105),
    (17,'Écran Samsung 19 po.',106),(18,'Écran Samsung 19 po.',107),(19,'Écran Samsung 19 po.',108),(20,'Écran Samsung 19 po.',109),(21,'Écran Samsung 19 po.',110),
    (22,'Écran Samsung 19 po.',111),(23,'Écran Samsung 19 po.',112),(24,'Écran Samsung 19 po.',113),(25,'Écran Samsung 19 po.',114),(26,'Écran Acer 24 po.',1),
    (27,'Écran Acer 24 po.',2),(28,'Écran Acer 24 po.',3),(29,'Écran Acer 24 po.',4),(30,'Écran Acer 24 po.',5),(31,'Écran Acer 24 po.',6),(32,'Écran Acer 24 po.',7),
    (33,'Écran Acer 24 po.',8),(34,'Écran Acer 24 po.',9),(35,'Écran Acer 24 po.',NULL),(36,'Écran Acer 24 po.',NULL),(37,'Écran Samsung 19 po.',115),
    (38,'Écran Samsung 19 po.',116),(39,'Écran Samsung 19 po.',117),(40,'Écran Samsung 19 po.',118),(41,'Écran Samsung 19 po.',119),(42,'Écran Samsung 19 po.',120),
    (43,'Écran Samsung 19 po.',121),(44,'Écran Samsung 19 po.',125),(45,'Écran Samsung 19 po.',123),(46,'Écran Samsung 19 po.',124),(47,'Écran Samsung 19 po.',NULL),
    (48,'Écran Samsung 19 po.',126),(49,'Écran Samsung 19 po.',127),(50,'Écran Samsung 19 po.',128),(51,'Écran Samsung 19 po.',NULL),(52,'Écran Samsung 19 po.',NULL),
    (53,'Écran Samsung 19 po.',NULL),(54,'Écran Samsung 19 po.',NULL),(55,'Écran Samsung 19 po.',NULL),(56,'Écran Samsung 19 po.',NULL),(57,'Écran Samsung 19 po.',NULL),
    (58,'Écran Samsung 19 po.',NULL),(59,'Écran Samsung 19 po.',NULL),(60,'Écran Samsung 19 po.',NULL),(61,'Écran Samsung 19 po.',NULL),(62,'Écran Samsung 19 po.',NULL),
    (63,'Écran Samsung 19 po.',NULL),(64,'Écran Samsung 19 po.',NULL),(65,'Écran Samsung 19 po.',NULL),(66,'Écran Samsung 19 po.',NULL),(67,'Écran Samsung 19 po.',NULL),
    (68,'Écran Samsung 19 po.',NULL),(69,'Écran Samsung 19 po.',NULL),(70,'Écran Samsung 19 po.',NULL),(71,'Écran Samsung 19 po.',NULL),(72,'Écran Samsung 19 po.',NULL),
    (73,'Écran Samsung 19 po.',NULL),(74,'Écran Samsung 19 po.',NULL),(75,'Écran Samsung 19 po.',NULL),(76,'Écran Samsung 19 po.',NULL),(77,'Écran Samsung 19 po.',NULL),
    (78,'Écran Samsung 19 po.',NULL),(79,'Écran Samsung 19 po.',NULL),(80,'Écran Samsung 19 po.',NULL),(81,'Écran Samsung 19 po.',NULL),(82,'Écran Samsung 19 po.',NULL),
    (83,'Écran Samsung 19 po.',NULL),(84,'Écran Samsung 19 po.',NULL),(85,'Écran Samsung 19 po.',NULL),(86,'Écran Samsung 19 po.',NULL),(87,'Écran Samsung 19 po.',NULL),
    (88,'Écran Samsung 19 po.',NULL),(89,'Écran Samsung 19 po.',NULL),(90,'Écran Samsung 19 po.',NULL),(91,'Écran Samsung 19 po.',NULL),(92,'Écran Samsung 19 po.',NULL),
    (93,'Écran Samsung 19 po.',NULL),(94,'Écran Samsung 19 po.',NULL),(95,'Écran Samsung 19 po.',NULL),(96,'Écran Samsung 19 po.',NULL),(97,'Écran Samsung 19 po.',NULL),
    (98,'Écran Samsung 19 po.',NULL),(99,'Écran Samsung 19 po.',NULL),(100,'Écran Samsung 19 po.',NULL),(101,'Écran Samsung 19 po.',NULL),(102,'Écran Samsung 19 po.',NULL),
    (103,'Écran Samsung 19 po.',NULL),(104,'Écran Samsung 19 po.',NULL),(105,'Écran Samsung 19 po.',NULL),(106,'Écran Samsung 19 po.',NULL),(107,'Écran Samsung 19 po.',NULL),
    (108,'Écran Samsung 19 po.',NULL),(109,'Écran Samsung 19 po.',NULL),(110,'Écran Samsung 19 po.',NULL),(111,'Écran Samsung 19 po.',NULL),(112,'Écran Samsung 19 po.',NULL),
    (113,'Écran Samsung 19 po.',NULL),(114,'Écran Samsung 19 po.',NULL),(115,'Écran Samsung 19 po.',NULL),(116,'Écran Samsung 19 po.',NULL),(117,'Écran Samsung 19 po.',NULL),
    (118,'Écran Samsung 19 po.',NULL),(119,'Écran Samsung 19 po.',NULL),(120,'Écran Samsung 19 po.',NULL),(121,'Écran Samsung 19 po.',NULL),(122,'Écran Samsung 19 po.',NULL),
    (123,'Écran Samsung 19 po.',NULL),(124,'Écran Samsung 19 po.',NULL),(125,'Écran Samsung 19 po.',NULL),(126,'Écran Samsung 19 po.',NULL),(127,'Écran Samsung 19 po.',NULL),
    (128,'Écran Samsung 19 po.',NULL),(129,'Écran Samsung 19 po.',NULL),(130,'Écran Samsung 19 po.',NULL),(131,'Écran Samsung 19 po.',NULL),(132,'Écran Samsung 19 po.',NULL),
    (133,'Écran Samsung 19 po.',NULL),(134,'Écran Samsung 19 po.',NULL),(135,'Écran Samsung 19 po.',NULL),(136,'Écran Samsung 19 po.',NULL),(137,'Écran Samsung 19 po.',NULL),
    (138,'Écran Samsung 19 po.',NULL),(139,'Écran Samsung 19 po.',NULL),(140,'Écran Samsung 19 po.',NULL),(141,'Écran Samsung 19 po.',NULL),(142,'Écran Samsung 19 po.',NULL),
    (143,'Écran Samsung 19 po.',NULL),(144,'Écran Samsung 19 po.',NULL),(145,'Écran Samsung 19 po.',NULL),(146,'Écran Samsung 19 po.',NULL),(147,'Écran Samsung 19 po.',NULL),
    (148,'Écran Samsung 19 po.',NULL),(149,'Écran Samsung 19 po.',NULL),(150,'Écran Samsung 19 po.',NULL),(151,'Écran Samsung 19 po.',NULL),(152,'Écran Samsung 19 po.',NULL),
    (153,'Écran Samsung 19 po.',NULL),(154,'Écran Samsung 19 po.',NULL),(155,'Écran Samsung 19 po.',NULL),(156,'Écran Samsung 19 po.',NULL),(157,'Écran Samsung 19 po.',NULL),
    (158,'Écran Samsung 19 po.',NULL),(159,'Écran Samsung 19 po.',NULL),(160,'Écran Samsung 19 po.',NULL),(161,'Écran Samsung 19 po.',NULL),(162,'Écran Samsung 19 po.',NULL),
    (163,'Écran Samsung 19 po.',NULL),(164,'Écran Samsung 19 po.',NULL),(165,'Écran Samsung 19 po.',NULL),(166,'Écran Samsung 19 po.',NULL),(167,'Écran Samsung 19 po.',NULL),
    (168,'Écran Samsung 19 po.',NULL),(169,'Écran Samsung 19 po.',NULL),(170,'Écran Samsung 19 po.',NULL),(171,'Écran Samsung 19 po.',NULL),(172,'Écran Samsung 19 po.',NULL),
    (173,'Écran Samsung 19 po.',NULL),(174,'Écran Samsung 19 po.',NULL),(175,'Écran Samsung 19 po.',NULL),(176,'Écran Samsung 19 po.',NULL),(177,'Écran Samsung 19 po.',NULL),
    (178,'Écran Samsung 19 po.',NULL),(179,'Écran Samsung 19 po.',NULL),(180,'Écran Samsung 19 po.',NULL),(181,'Écran Samsung 19 po.',NULL),(182,'Écran Samsung 19 po.',NULL),
    (183,'Écran Samsung 19 po.',NULL),(184,'Écran Samsung 19 po.',NULL),(185,'Écran Samsung 19 po.',NULL),(186,'Écran Samsung 19 po.',NULL),(187,'Écran Samsung 19 po.',NULL),
    (188,'Écran Samsung 19 po.',NULL),(189,'Écran Samsung 19 po.',NULL),(190,'Écran Samsung 19 po.',NULL),(191,'Écran Samsung 19 po.',NULL),(192,'Écran Samsung 19 po.',NULL),
    (193,'Écran Samsung 19 po.',NULL),(194,'Écran Samsung 19 po.',NULL),(195,'Écran Samsung 19 po.',NULL),(196,'Écran Samsung 19 po.',NULL),(197,'Écran Samsung 19 po.',NULL),
    (198,'Écran Samsung 19 po.',NULL),(199,'Écran Samsung 19 po.',NULL),(200,'Écran Samsung 19 po.',NULL),(201,'Écran Samsung 19 po.',NULL),(202,'Écran Samsung 19 po.',NULL),
    (203,'Écran Samsung 19 po.',NULL),(204,'Écran Samsung 19 po.',NULL),(205,'Écran Samsung 19 po.',NULL),(206,'Écran Samsung 19 po.',NULL),(207,'Écran Samsung 19 po.',NULL),
    (208,'Écran Samsung 19 po.',NULL),(209,'Écran Samsung 19 po.',NULL),(210,'Écran Samsung 19 po.',NULL),(211,'Écran Samsung 19 po.',NULL),(212,'Écran Samsung 19 po.',NULL),
    (213,'Souris',1),(214,'Souris',2),(215,'Souris',3),(216,'Souris',4),(217,'Souris',5),(218,'Souris',6),(219,'Souris',7),(220,'Souris',8),(221,'Souris',9),
    (222,'Souris',NULL),(223,'Souris',NULL),(224,'Souris',NULL),(225,'Souris',NULL),(226,'Souris',NULL),(227,'Souris',NULL),(228,'Souris',NULL),(229,'Souris',NULL),
    (230,'Souris',NULL),(231,'Souris',NULL),(232,'Souris',NULL),(233,'Souris',NULL),(234,'Souris',NULL),(235,'Souris',NULL),(236,'Souris',NULL),(237,'Souris',NULL),
    (238,'Souris',NULL),(239,'Souris',NULL),(240,'Souris',NULL),(241,'Souris',NULL),(242,'Souris',NULL),(243,'Souris',NULL),(244,'Souris',NULL),(245,'Souris',NULL),
    (246,'Souris',NULL),(247,'Souris',NULL),(248,'Souris',NULL),(249,'Souris',NULL),(250,'Souris',NULL),(251,'Souris',NULL),(252,'Souris',NULL),(253,'Souris',NULL),
    (254,'Souris',NULL),(255,'Souris',NULL),(256,'Souris',NULL),(257,'Souris',NULL),(258,'Souris',NULL),(259,'Souris',NULL),(260,'Souris',NULL),(261,'Souris',NULL),
    (262,'Souris',NULL),(263,'Souris',NULL),(264,'Souris',NULL),(265,'Souris',NULL),(266,'Souris',NULL),(267,'Souris',NULL),(268,'Souris',NULL),(269,'Souris',NULL),
    (270,'Souris',NULL),(271,'Souris',NULL),(272,'Souris',NULL),(273,'Souris',NULL),(274,'Souris',NULL),(275,'Souris',NULL),(276,'Souris',NULL),(277,'Souris',NULL),
    (278,'Souris',NULL),(279,'Souris',NULL),(280,'Souris',NULL),(281,'Souris',NULL),(282,'Souris',NULL),(283,'Souris',NULL),(284,'Souris',NULL),(285,'Souris',NULL),
    (286,'Souris',NULL),(287,'Souris',NULL),(288,'Souris',NULL),(289,'Souris',NULL),(290,'Souris',NULL),(291,'Souris',NULL),(292,'Souris',NULL),(293,'Souris',NULL),
    (294,'Souris',NULL),(295,'Souris',NULL),(296,'Souris',NULL),(297,'Souris',NULL),(298,'Souris',NULL),(299,'Souris',NULL),(300,'Souris',NULL),(301,'Souris',NULL),
    (302,'Souris',NULL),(303,'Souris',NULL),(304,'Souris',NULL),(305,'Souris',NULL),(306,'Souris',NULL),(307,'Souris',NULL),(308,'Souris',NULL),(309,'Souris',NULL),
    (310,'Souris',NULL),(311,'Souris',NULL),(312,'Souris',NULL),(313,'Souris',NULL),(314,'Souris',NULL),(315,'Souris',NULL),(316,'Souris',NULL),(317,'Souris',NULL),
    (318,'Souris',NULL),(319,'Souris',NULL),(320,'Souris',NULL),(321,'Souris',NULL),(322,'Souris',NULL),(323,'Souris',NULL),(324,'Souris',NULL),(325,'Souris',NULL),
    (326,'Souris',NULL),(327,'Souris',NULL),(328,'Souris',NULL),(329,'Souris',NULL),(330,'Souris',NULL),(331,'Souris',NULL),(332,'Souris',NULL),(333,'Souris',NULL),
    (334,'Souris',NULL),(335,'Souris',NULL),(336,'Souris',NULL),(337,'Souris',NULL),(338,'Souris',NULL),(339,'Souris',NULL),(340,'Souris',NULL),(341,'Souris',NULL),
    (342,'Souris',NULL),(343,'Souris',NULL),(344,'Souris',NULL),(345,'Souris',NULL),(346,'Souris',NULL),(347,'Souris',NULL),(348,'Souris',NULL),(349,'Souris',NULL),
    (350,'Souris',NULL),(351,'Souris',NULL),(352,'Souris',NULL),(353,'Souris',NULL),(354,'Souris',NULL),(355,'Souris',NULL),(356,'Souris',NULL),(357,'Souris',NULL),
    (358,'Souris',NULL),(359,'Souris',NULL),(360,'Souris',NULL),(361,'Souris',NULL),(362,'Souris',NULL),(363,'Souris',NULL),(364,'Souris',NULL),(365,'Souris',NULL),
    (366,'Souris',NULL),(367,'Souris',NULL),(368,'Souris',NULL),(369,'Souris',NULL),(370,'Souris',NULL),(371,'Souris',NULL),(372,'Souris',NULL),(373,'Souris',NULL),
    (374,'Souris',NULL),(375,'Souris',NULL),(376,'Souris',NULL),(377,'Souris',NULL),(378,'Souris',NULL),(379,'Souris',NULL),(380,'Souris',NULL),(381,'Souris',NULL),
    (382,'Souris',NULL),(383,'Souris',NULL),(384,'Souris',NULL),(385,'Souris',NULL),(386,'Souris',NULL),(387,'Souris',NULL),(388,'Souris',NULL),(389,'Souris',NULL),
    (390,'Souris',NULL),(391,'Souris',NULL),(392,'Souris',NULL),(393,'Souris',NULL),(394,'Souris',NULL),(395,'Souris',NULL),(396,'Souris',NULL),(397,'Souris',NULL),
    (398,'Souris',NULL),(399,'Souris',NULL),(400,'Souris',NULL),(401,'Souris',NULL),(402,'Souris',NULL),(403,'Souris',NULL),(404,'Souris',NULL),(405,'Souris',NULL),
    (406,'Souris',NULL),(407,'Souris',NULL),(408,'Souris',NULL),(409,'Souris',NULL),(410,'Souris',NULL),(411,'Souris',NULL),(412,'Souris',NULL),(413,'Souris',NULL),
    (414,'Souris',NULL),(415,'Souris',NULL),(416,'Souris',NULL),(417,'Souris',NULL),(418,'Souris',NULL),(419,'Souris',NULL),(420,'Souris',NULL),(421,'Souris',NULL),
    (422,'Souris',NULL),(423,'Souris',NULL),(424,'Souris',NULL),(425,'Souris',NULL),(426,'Souris',NULL),(427,'Souris',NULL),(428,'Souris',NULL),(429,'Souris',NULL),
    (430,'Souris',NULL),(431,'Souris',NULL),(432,'Souris',NULL),(433,'Souris',NULL),(434,'Souris',NULL),(435,'Souris',NULL),(436,'Souris',NULL),(437,'Souris',NULL),
    (438,'Souris',NULL),(439,'Souris',NULL),(440,'Souris',NULL),(441,'Souris',NULL),(442,'Souris',NULL),(443,'Souris',NULL),(444,'Clavier',1),(445,'Clavier',2),
    (446,'Clavier',3),(447,'Clavier',4),(448,'Clavier',5),(449,'Clavier',6),(450,'Clavier',7),(451,'Clavier',8),(452,'Clavier',9),(453,'Clavier',NULL),(454,'Clavier',NULL),
    (455,'Clavier',NULL),(456,'Clavier',NULL),(457,'Clavier',NULL),(458,'Clavier',NULL),(459,'Clavier',NULL),(460,'Clavier',NULL),(461,'Souris',NULL),(462,'Clavier',NULL),
    (463,'Clavier',NULL),(464,'Clavier',NULL),(465,'Clavier',NULL),(466,'Clavier',NULL),(467,'Clavier',NULL),(468,'Clavier',NULL),(469,'Clavier',NULL),(470,'Clavier',NULL),
    (471,'Clavier',NULL),(472,'Clavier',NULL),(473,'Clavier',NULL),(474,'Clavier',NULL),(475,'Clavier',NULL),(476,'Clavier',NULL),(477,'Clavier',NULL),(478,'Clavier',NULL),
    (479,'Clavier',NULL),(480,'Clavier',NULL),(481,'Clavier',NULL),(482,'Clavier',NULL),(483,'Clavier',NULL),(484,'Clavier',NULL),(485,'Clavier',NULL),(486,'Clavier',NULL),
    (487,'Clavier',NULL),(488,'Clavier',NULL),(489,'Clavier',NULL),(490,'Clavier',NULL),(491,'Clavier',NULL),(492,'Clavier',NULL),(493,'Clavier',NULL),(494,'Clavier',NULL),
    (495,'Clavier',NULL),(496,'Clavier',NULL),(497,'Clavier',NULL),(498,'Clavier',NULL),(499,'Clavier',NULL),(500,'Clavier',NULL),(501,'Clavier',NULL),(502,'Clavier',NULL),
    (503,'Clavier',NULL),(504,'Clavier',NULL),(505,'Clavier',NULL),(506,'Clavier',NULL),(507,'Clavier',NULL),(508,'Clavier',NULL),(509,'Clavier',NULL),(510,'Clavier',NULL),
    (511,'Clavier',NULL),(512,'Clavier',NULL),(513,'Clavier',NULL),(514,'Clavier',NULL),(515,'Clavier',NULL),(516,'Clavier',NULL),(517,'Clavier',NULL),(518,'Clavier',NULL),
    (519,'Clavier',NULL),(520,'Clavier',NULL),(521,'Clavier',NULL),(522,'Clavier',NULL),(523,'Clavier',NULL),(524,'Clavier',NULL),(525,'Clavier',NULL),(526,'Clavier',NULL),
    (527,'Clavier',NULL),(528,'Clavier',NULL),(529,'Clavier',NULL),(530,'Clavier',NULL),(531,'Clavier',NULL),(532,'Clavier',NULL),(533,'Clavier',NULL),(534,'Clavier',NULL),
    (535,'Clavier',NULL),(536,'Clavier',NULL),(537,'Clavier',NULL),(538,'Clavier',NULL),(539,'Clavier',NULL),(540,'Clavier',NULL),(541,'Clavier',NULL),(542,'Clavier',NULL),
    (543,'Clavier',NULL),(544,'Clavier',NULL),(545,'Clavier',NULL),(546,'Clavier',NULL),(547,'Clavier',NULL),(548,'Clavier',NULL),(549,'Clavier',NULL),(550,'Clavier',NULL),
    (551,'Clavier',NULL),(552,'Clavier',NULL),(553,'Clavier',NULL),(554,'Clavier',NULL),(555,'Clavier',NULL),(556,'Clavier',NULL),(557,'Clavier',NULL),(558,'Clavier',NULL),
    (559,'Clavier',NULL),(560,'Clavier',NULL),(561,'Clavier',NULL),(562,'Clavier',NULL),(563,'Clavier',NULL),(564,'Clavier',NULL),(565,'Clavier',NULL),(566,'Clavier',NULL),
    (567,'Clavier',NULL),(568,'Clavier',NULL),(569,'Clavier',NULL),(570,'Clavier',NULL),(571,'Clavier',NULL),(572,'Clavier',NULL),(573,'Clavier',NULL),(574,'Clavier',NULL),
    (575,'Clavier',NULL),(576,'Clavier',NULL),(577,'Clavier',NULL),(578,'Clavier',NULL),(579,'Clavier',NULL),(580,'Clavier',NULL),(581,'Clavier',NULL),(582,'Clavier',NULL),
    (583,'Clavier',NULL),(584,'Clavier',NULL),(585,'Clavier',NULL),(586,'Clavier',NULL),(587,'Clavier',NULL),(588,'Clavier',NULL),(589,'Clavier',NULL),(590,'Clavier',NULL),
    (591,'Clavier',NULL),(592,'Clavier',NULL),(593,'Clavier',NULL),(594,'Clavier',NULL),(595,'Clavier',NULL),(596,'Clavier',NULL),(597,'Clavier',NULL),(598,'Clavier',NULL),
    (599,'Clavier',NULL),(600,'Clavier',NULL),(601,'Clavier',NULL),(602,'Clavier',NULL),(603,'Clavier',NULL),(604,'Clavier',NULL),(605,'Clavier',NULL),(606,'Clavier',NULL),
    (607,'Clavier',NULL),(608,'Clavier',NULL),(609,'Clavier',NULL),(610,'Clavier',NULL),(611,'Clavier',NULL),(612,'Clavier',NULL),(613,'Clavier',NULL),(614,'Clavier',NULL),
    (615,'Clavier',NULL),(616,'Clavier',NULL),(617,'Clavier',NULL),(618,'Clavier',NULL),(619,'Clavier',NULL),(620,'Clavier',NULL),(621,'Clavier',NULL),(622,'Clavier',NULL),
    (623,'Clavier',NULL),(624,'Clavier',NULL),(625,'Clavier',NULL),(626,'Clavier',NULL),(627,'Clavier',NULL),(628,'Clavier',NULL),(629,'Clavier',NULL),(630,'Clavier',NULL),
    (631,'Clavier',NULL),(632,'Clavier',NULL),(633,'Clavier',NULL),(634,'Clavier',NULL),(635,'Clavier',NULL),(636,'Clavier',NULL),(637,'Clavier',NULL),(638,'Clavier',NULL),
    (639,'Clavier',NULL),(640,'Clavier',NULL),(641,'Clavier',NULL),(642,'Clavier',NULL),(643,'Clavier',NULL),(644,'Clavier',NULL),(645,'Clavier',NULL),(646,'Clavier',NULL),
    (647,'Clavier',NULL),(648,'Clavier',NULL),(649,'Clavier',NULL),(650,'Clavier',NULL),(651,'Clavier',NULL),(652,'Clavier',NULL),(653,'Clavier',NULL),(654,'Clavier',NULL),
    (655,'Clavier',NULL),(656,'Clavier',NULL),(657,'Clavier',NULL),(658,'Clavier',NULL),(659,'Clavier',NULL),(660,'Clavier',NULL),(661,'Clavier',NULL),(662,'Clavier',NULL),
    (663,'Clavier',NULL),(664,'Clavier',NULL),(665,'Clavier',NULL),(666,'Clavier',NULL),(667,'Clavier',NULL),(668,'Clavier',NULL),(669,'Clavier',NULL),(670,'Clavier',NULL),
    (671,'Clavier',NULL),(672,'Imprimante NB LaserJet 4014DN.',NULL),(673,'Imprimante NB LaserJet 4014DN.',NULL),(674,'Imprimante NB LaserJet 4014DN.',NULL),
    (675,'Imprimante NB LaserJet 4014DN.',NULL),(676,'Imprimante NB HP 4050N',NULL),(677,'Imprimante NB HP 4050N',NULL),(678,'Imprimante NB HP 4050N',NULL),
    (679,'Imprimante NB HP 4050N',NULL);

INSERT INTO poste_has_tbl_logiciel 
	VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,6),(8,6),(9,6),(6,12),(7,12),(8,12),(9,12),(10,12),(100,12),(101,12),(102,12),(103,12),
    (104,12),(105,12),(106,12),(107,12),(108,12),(109,12),(110,12),(111,12),(112,12),(113,12),(114,12),(115,12),(116,12),(117,12),(118,12),
    (119,12),(120,12),(121,12),(122,12),(123,12),(124,12),(125,12),(126,12),(127,12),(128,12),(129,12),(130,12),(131,12),(132,12),(133,12),
    (134,12),(135,12),(136,12),(137,12),(138,12),(139,12),(140,12),(141,12),(142,12),(143,12),(144,12),(145,12),(146,12),(147,12),(148,12),
    (149,12),(150,12),(151,12),(152,12),(153,12),(154,12),(155,12),(156,12),(157,12),(158,12),(159,12),(160,12),(161,12),(162,12),(163,12),
    (164,12),(165,12),(166,12),(167,12),(168,12),(169,12),(170,12),(171,12),(172,12),(10,14),(100,14),(101,14),(102,14),(103,14),(104,14),
    (105,14),(106,14),(107,14),(108,14),(109,14),(110,14),(111,14),(112,14),(113,14),(114,14),(115,14),(116,14),(117,14),(118,14),(119,14),
    (120,14),(121,14),(122,14),(123,14),(124,14),(125,14),(126,14),(127,14),(128,14),(129,14),(130,14),(131,14),(132,14),(133,14),(134,14),
    (135,14),(136,14),(137,14),(138,14),(139,14),(140,14),(141,14),(142,14),(143,14),(144,14),(145,14),(146,14),(147,14),(148,14),(149,14),
    (150,14),(151,14),(152,14),(153,14),(154,14),(155,14),(156,14),(157,14),(158,14),(159,14),(160,14),(161,14),(162,14),(163,14),(164,14),
    (165,14),(166,14),(167,14),(168,14),(169,14),(170,14),(171,14),(172,14),(6,18),(7,18),(8,18),(9,18),(100,18),(101,18),(102,18),(103,18),
    (104,18),(105,18),(106,18),(107,18),(108,18),(109,18),(110,18),(111,18),(112,18),(113,18),(114,18),(115,18),(116,18),(119,18),(120,18),
    (121,18),(122,18),(123,18),(124,18),(125,18),(126,18),(127,18),(128,18),(129,18),(130,18),(131,18),(132,18),(133,18),(134,18),(135,18),
    (136,18),(137,18),(138,18),(139,18),(140,18),(141,18),(142,18),(143,18),(144,18),(145,18),(146,18),(147,18),(148,18),(149,18),(150,18),
    (151,18),(152,18),(153,18),(154,18),(155,18),(156,18),(157,18),(158,18),(159,18),(160,18),(161,18),(162,18),(163,18),(164,18),(165,18),
    (166,18),(167,18),(168,18),(169,18),(170,18),(171,18),(172,18),(177,18),(188,18),(1,22),(2,22),(3,22),(4,22),(5,22),(6,22),(7,22),(8,22),
    (9,22),(10,22),(100,22),(101,22),(102,22),(103,22),(104,22),(105,22),(106,22),(107,22),(108,22),(109,22),(110,22),(111,22),(112,22),(113,22),
    (114,22),(115,22),(116,22),(117,22),(118,22),(119,22),(120,22),(121,22),(122,22),(123,22),(124,22),(125,22),(126,22),(127,22),(128,22),(129,22),
    (130,22),(131,22),(132,22),(133,22),(134,22),(135,22),(136,22),(137,22),(138,22),(139,22),(140,22),(141,22),(142,22),(143,22),(144,22),(145,22),
    (146,22),(147,22),(148,22),(149,22),(150,22),(151,22),(152,22),(153,22),(154,22),(155,22),(156,22),(157,22),(158,22),(159,22),(160,22),(161,22),
    (162,22),(163,22),(164,22),(165,22),(166,22),(167,22),(168,22),(169,22),(170,22),(171,22),(172,22);

INSERT INTO poste_has_tbl_usager (id_poste , id_usager)
	VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(100,1000),(101,1001),(102,1002),(103,1003),(104,1004),(105,1005),
    (106,1006),(107,1007),(108,1008),(109,1009),(110,1010),(111,1011),(112,1012),(113,1013),(114,1014),(115,1015),(116,1016),(117,1017),
    (118,1018),(119,1019),(173,1073),(174,1074),(175,1075),(176,1076),(177,1077),(178,1078),(179,1079),(180,1080),(181,1081),(182,1082),
    (183,1083),(184,1084),(185,1085),(186,1086),(187,1087),(188,1088),(189,1089),(190,1090),(191,1091),(192,1092),(193,1093),(194,1094),
    (195,1095),(196,1096),(197,1097),(198,1098),(199,1099);


/* Étape 3 : Ajout de tables et de colonnes
Modifier votre base de données en ajoutant les informations suivantes :
 tbl_usager ajouter un champ type d'usagers qui doit être une clé étrangère d'une nouvelle
table type d'usager.
 tbl_local ajouter les champs suivants :
 Nombre du bureau
 Nombre de prise Ethernet
 Imprimante (dois être en lien avec les périphériques)
 tbl_péripherique
 Ajouter un champ type de périphérique qui doit être une clé étrangère d'une nouvelle
table type de périphérique. */

-- Add a new column 'type_Usager' to table 'usager' in schema 'TP2'
ALTER TABLE TP2.usager
    ADD type_usager int NULL;

-- Update rows in table 'usager'
UPDATE usager
SET
    type_usager = 1
WHERE id_usager BETWEEN 1 AND 9;

-- Update rows in table 'usager'
UPDATE usager
SET
    type_usager = 2
WHERE 	id_usager BETWEEN 100 AND 999;

-- Update rows in table 'usager'
UPDATE usager
SET
    type_usager = 3
WHERE id_usager >= 1000;

-- Create a new table called 'type_usager' in schema 'TP2'
-- Drop the table if it already exists
IF OBJECT_ID('TP2.type_usager', 'U') IS NOT NULL
DROP TABLE TP2.type_usager;
-- Create the table in the specified schema
CREATE TABLE TP2.type_usager
(
    id_type_usager INT NOT NULL PRIMARY KEY, -- primary key column
    type_usager VARCHAR(15) NOT NULL
) engine=InnoDB;

-- Insert rows into table 'type_usager'
INSERT INTO type_usager
    VALUES
( -- first row: values for the columns in the list above
 1, 'Professeur'
),
( -- second row: values for the columns in the list above
 2, 'Employe'
),
(
3, 'Etudiant'
);

ALTER TABLE usager 
    Add constraint fk_usager_type_usager
    foreign key (type_usager) references type_usager (id_type_usager);

-- Add a new column 'nombre_bureau', 'nb_prise_Ethernet', 'imprimante' to table 'local'
ALTER TABLE local
    ADD nombre_bureau int(11) NULL,
    ADD nb_prise_Ethernet int(11) null,
    ADD imprimante varchar(45) not null;

ALTER TABLE peripherique
    ADD id_type_peripherique int(11) not null;

-- Create a new table called 'type_peripherique' in schema 'TP2'
-- Drop the table if it already exists
IF OBJECT_ID('TP2.type_peripherique', 'U') IS NOT NULL
DROP TABLE TP2.type_peripherique;
-- Create the table in the specified schema
CREATE TABLE TP2.type_peripherique
(
    id_type_peripherique INT NOT NULL PRIMARY KEY, -- primary key column
    nom_type VARCHAR(45) NOT NULL
) engine=innodb;

-- Insert rows into table 'type_peripherique'
INSERT INTO type_peripherique
VALUES
( -- first row: values for the columns in the list above
 1, 'Ecran'
),
( -- second row: values for the columns in the list above
 2, 'Imprimante'
),
( -- third row: values for the columns in the list above
 3,'Souris'
),
( -- fourth row: values for the columns in the list above
    4,'Clavier'
);

-- Update rows in table 'peripherique'
UPDATE peripherique
SET
    type_peripherique = 1
WHERE nom_peripherique LIKE 'Écran%';

-- Update rows in table 'peripherique'
UPDATE peripherique
SET
    type_peripherique = 1
WHERE nom_peripherique LIKE 'Souris';

-- Update rows in table 'peripherique'
UPDATE peripherique
SET
    type_peripherique = 1
WHERE nom_peripherique LIKE 'Clavier';

-- Update rows in table 'peripherique'
UPDATE peripherique
SET
    type_peripherique = 1
WHERE nom_peripherique LIKE 'Imprimante';

ALTER TABLE peripherique
    ADD constraint fk_peripherique_id_type_peripherique
    foreign key (type_peripherique) references (id_type_peripherique);

-- ---------------------------------------- --
-- Etape 4 : Ajout des contraintes          --
-- ---------------------------------------- --
    
ALTER TABLE usager
    ADD index idxNomPrenom (nom_usager, prenom_usager);

CREATE FULLTEXT Index idxPosteProcesseur
    ON poste (desc_poste, desc_processeur);

ALTER TABLE local MODIFY nom_local varchar(45) not null,
    ADD constraint un_nom_local unique (nom_local);

ALTER TABLE logiciel MODIFY nom_logiciel varchar(45) not null,
    ADD constraint un_nom_logiciel unique (nom_logiciel);

ALTER TABLE editeur MODIFY nom_editeur varchar(45) not null,
    ADD constraint un_nom_editeur unique (nom_editeur);

ALTER TABLE fabricant MODIFY nom_fabricant varchar(45) not null,
    ADD constraint un_nom_fabricant unique (nom_fabricant);

-- Update rows in table 'local'
UPDATE local
SET
    nombre_bureau = 16,
    nb_prise_Ethernet = 16,
    imprimante = 675
WHERE nom_local = 'P-210';

-- Update rows in table 'local'
UPDATE local
SET
    nombre_bureau = 27,
    nb_prise_Ethernet = ,
    imprimante = 676
WHERE nom_local = 'P-308';

-- Update rows in table 'local'
UPDATE local
SET
    nombre_bureau = 27,
    nb_prise_Ethernet = 27,
    imprimante = 677
WHERE nom_local = 'P-309';

-- Update rows in table 'local'
UPDATE local
SET
    nombre_bureau = 27,
    nb_prise_Ethernet = 27,
    imprimante = 678
WHERE nom_local = 'P-409';

-- Update rows in table 'local'
UPDATE local
SET
    nombre_bureau = 5,
    nb_prise_Ethernet = 6,
    imprimante = 673
WHERE nom_local = 'P-416';

-- Update rows in table 'local'
UPDATE local
SET
    nombre_bureau = 27,
    nb_prise_Ethernet = 27,
    imprimante = 679
WHERE nom_local = 'P-418';

-- ---------------------------------------- --
-- Etape 6 : Instructions SELECT            --
-- ---------------------------------------- --

-- Numero 1 --
select
    concat(usa.nom_usager, ' ', usa.prenom_usager) as ' Nom complet',
    loc.nom_local as 'Nom de local',
    pos.id_poste as 'Nom du poste'
from usager as usa
    inner join local as loc
        on usa.id_local = loc.id_local
    inner join usager_has_tbl_poste as usapo
        on usa.id_usager = usapo.id_usager
    inner join poste as pos
        on usapo.id_poste = id_poste;

-- Numero 2 --
select 
    count(usa.id_poste) as 'Poste de travail affectés',
    (count(pos.id_poste) - count(usa.id_poste)) as 'Poste de travail non affectés'
from usager_has_tbl_poste as usa
    inner join poste as pos
        on usa.id_poste = pos.id_poste;

-- Numero 4 --
select 
    log.nom_logiciel as 'Nom logiciel',
    count(log.id_logiciel) as 'Nombre Installation'
from logiciel as log
    inner join poste_has_tbl_logiciel as polo
        on log.id_logiciel - polo.id_logiciel;

-- Numero 5 --
select
    loc.nom_local as 'Nom Local',
    count(usa.id_local) as 'Nombre usager'
from local as loc
    inner join usager as usa
        on loc.id_local = usa.id_local;

-- Numero 6 --








        
    
INSERT INTO `iss_db`.`users`
(`password`,
`user_type`,
`username`)
VALUES
('g','DOCTOR','george');


INSERT INTO `iss_db`.`users`
(`password`,
`user_type`,
`username`)
VALUES
('u','DOCTOR','ursu');

INSERT INTO `iss_db`.`hospitals`
(`address`,
`name`)
VALUES
('Str. Clinicilor 3-5',
'Spitalul CLuj-Napoca');


INSERT INTO `iss_db`.`doctors`
(`first_name`,
`last_name`,
`hospital_id`,
`user_id`)
VALUES
('Gradinariu','George',1,1);



INSERT INTO `iss_db`.`doctors`
(`first_name`,
`last_name`,
`hospital_id`,
`user_id`)
VALUES
('Bogdan','Ioan',1,2);

------------------------------------------------------------------------------------------------------
#DONORS


INSERT INTO `iss_db`.`users`
(`password`,
`user_type`,
`username`)
VALUES
('g','DONOR','georgeDonor');

INSERT INTO `iss_db`.`donors`
(`address`,
`birthday`,
`cnp`,
`email`,
`first_name`,
`gender`,
`last_name`,
`local_address`,
`phone`,
`user_id`)
VALUES
('Str.Primaverii nr.2 Bloc S4','26/03/1997','1970326330099','gradinariu.george97@gmail.com','George','Male','Gradinariu','Jud.Cluj, Oras. Cluj-Napoca, Str.Primaverii Nr.2','075547716',3);




INSERT INTO `iss_db`.`users`
(`password`,
`user_type`,
`username`)
VALUES
('b','DONOR','bogdan');

INSERT INTO `iss_db`.`donors`
(`address`,
`birthday`,
`cnp`,
`email`,
`first_name`,
`gender`,
`last_name`,
`local_address`,
`phone`,
`user_id`)
VALUES
('Oltenia','29/09/1997','1970929338989','bogdanioan63@gmail.com','Bogdan','Male','Ioan','Jud.Cluj, Oras. Cluj-Napoca, Camin Hasdeu','075547716',4);



INSERT INTO `iss_db`.`users`
(`password`,
`user_type`,
`username`)
VALUES
('a','DONOR','alex');

INSERT INTO `iss_db`.`donors`
(`address`,
`birthday`,
`cnp`,
`email`,
`first_name`,
`gender`,
`last_name`,
`local_address`,
`phone`,
`user_id`)
VALUES
('Camin Hasdeu','22/02/1999','1970929338989','alexandru.ivanov98@gmail.com','Alexandru','Male','Ivanov','Jud.Neamt, Oras. Piatra Neamt','0755878782',5);



INSERT INTO `iss_db`.`users`
(`password`,
`user_type`,
`username`)
VALUES
('v','DONOR','victor');

INSERT INTO `iss_db`.`donors`
(`address`,
`birthday`,
`cnp`,
`email`,
`first_name`,
`gender`,
`last_name`,
`local_address`,
`phone`,
`user_id`)
VALUES
('Gheorgheni','20/11/1997','19711203398983','victor.georgescu07@gmail.com','Victor','Male','Georgescu','Jud.Cluj, Oras. Cluj-Napoca, ,Str. Panselutei','0755909090',6);




INSERT INTO `iss_db`.`users`
(`password`,
`user_type`,
`username`)
VALUES
('d','DONOR','dani');

INSERT INTO `iss_db`.`donors`
(`address`,
`birthday`,
`cnp`,
`email`,
`first_name`,
`gender`,
`last_name`,
`local_address`,
`phone`,
`user_id`)
VALUES
('Jud. Suceava, Burdujeni','10/10/1997','1971010338765','danielteodorovici@yahoo.com','Daniel','Male','Teodorovici','Jud.Cluj, Oras. Cluj-Napoca,Str. Marasti','0755232389',7);


INSERT INTO `iss_db`.`users`
(`password`,
`user_type`,
`username`)
VALUES
('d','DONOR','denisa');

INSERT INTO `iss_db`.`donors`
(`address`,
`birthday`,
`cnp`,
`email`,
`first_name`,
`gender`,
`last_name`,
`local_address`,
`phone`,
`user_id`)
VALUES
('Zalau','23/06/1997','2970623332225','denisamholhos@gmail.com','Holhos','Fema','Denisa','Jud.Cluj, Oras. Cluj-Napoca, Camin Hasdeu','0744529856',8);


INSERT INTO `iss_db`.`users`
(`password`,
`user_type`,
`username`)
VALUES
('a','DONOR','alisa');

INSERT INTO `iss_db`.`donors`
(`address`,
`birthday`,
`cnp`,
`email`,
`first_name`,
`gender`,
`last_name`,
`local_address`,
`phone`,
`user_id`)
VALUES
('Medias','05/09/1998','2980905224565','holerga.alisa@yahoo.com','Holerga','Female','Alisa','Jud.Cluj, Oras. CLuj-Napoca,Str. Marasti','0755232389',9);

INSERT INTO `iss_db`.`users`
(`password`,
`user_type`,
`username`)
VALUES
('c','DONOR','cipri');

INSERT INTO `iss_db`.`donors`
(`address`,
`birthday`,
`cnp`,
`email`,
`first_name`,
`gender`,
`last_name`,
`local_address`,
`phone`,
`user_id`)
VALUES
('Jud. Oradea','12/03/1997','1970312338565','fodorciprtian97@yahoo.com','Ciprian','Male','Fodor','Jud.Cluj, Oras. CLuj-Napoca,Str. Calea Manastur','0755321313',10);


------------------------------------------------------------------------------------------------------
#PERSONNEL


INSERT INTO `iss_db`.`users`
(`password`,
`user_type`,
`username`)
VALUES
('i','PERSONNEL','ioan');


INSERT INTO `iss_db`.`users`
(`password`,
`user_type`,
`username`)
VALUES
('g','PERSONNEL','gradinariu');





INSERT INTO `iss_db`.`personnel`
(`first_name`,
`last_name`,
`user_id`)
VALUES
('Bogdan','Ioan',11);

INSERT INTO `iss_db`.`personnel`
(`first_name`,
`last_name`,
`user_id`)
VALUES
('Gradinariu','George',12);



------------------------------------------------------------------------------------------------------
#REQUESTS


INSERT INTO `iss_db`.`requests`
(`blood_category`,
`blood_quantity`,
`blood_rh`,
`blood_type`,
`for_person`,
`priority`,
`request_date`,
`status`,
`summary`,
`doctor_id`)
VALUES
('WHOLE',2,'POSITIVE','A',1,'NORMAL','2018-06-03','OPEN','',1);

INSERT INTO `iss_db`.`requests`
(`blood_category`,
`blood_quantity`,
`blood_rh`,
`blood_type`,
`for_person`,	
`priority`,
`request_date`,
`status`,
`summary`,
`doctor_id`)
VALUES
('PLASMA',1,'POSITIVE','O',1,'LOW','2018-06-05','OPEN','',2);

INSERT INTO `iss_db`.`requests`
(`blood_category`,
`blood_quantity`,
`blood_rh`,
`blood_type`,
`for_person`,
`priority`,
`request_date`,
`status`,
`summary`,
`doctor_id`)
VALUES
('PLASMA',4,'NEGATIVE','B',1,'HIGH','2018-06-05','OPEN','',1);


INSERT INTO `iss_db`.`requests`
(`blood_category`,
`blood_quantity`,
`blood_rh`,
`blood_type`,
`for_person`,
`priority`,
`request_date`,
`status`,
`summary`,
`doctor_id`)
VALUES
('REDCELL',4,'POSITIVE','A',1,'HIGH','2018-06-05','OPEN','',2);


INSERT INTO `iss_db`.`requests`
(`blood_category`,
`blood_quantity`,
`blood_rh`,
`blood_type`,
`for_person`,
`priority`,
`request_date`,
`status`,
`summary`,
`doctor_id`)
VALUES
('WHOLE',4,'NEGATIVE','AB',1,'HIGH','2018-06-05','IN_PROGRESS','Looking for donors as quick as we can',1);


INSERT INTO `iss_db`.`requests`
(`blood_category`,
`blood_quantity`,
`blood_rh`,
`blood_type`,
`for_person`,
`priority`,
`request_date`,
`status`,
`summary`,
`doctor_id`)
VALUES
('PLASMA',1,'NEGATIVE','O',1,'HIGH','2018-06-03','ACCEPTED','',2);


------------------------------------------------------------------------------------------------------
#DONATIONS


INSERT INTO `iss_db`.`donations`
(`id`,
`blood_rh`,
`blood_type`,
`collection_date`,
`for_person`,
`request_date`,
`status`,
`id_donor`)
VALUES
(1,'NEGATIVE','A','2018-07-02','','2018-06-23','ACCEPTED',3);


INSERT INTO `iss_db`.`donations`
(`id`,
`blood_rh`,
`blood_type`,
`collection_date`,
`for_person`,
`request_date`,
`status`,
`id_donor`)
VALUES
(2,'POSITIVE','AB','2018-07-03','','2018-06-24','OPEN',4);

INSERT INTO `iss_db`.`donations`
(`id`,
`blood_rh`,
`blood_type`,
`collection_date`,
`for_person`,
`request_date`,
`status`,
`id_donor`)
VALUES
(3,'NEGATIVE','O','2018-07-03','','2018-06-24','OPEN',5);


INSERT INTO `iss_db`.`donations`
(`id`,
`blood_rh`,
`blood_type`,
`collection_date`,
`for_person`,
`request_date`,
`status`,
`id_donor`)
VALUES
(4,'POSITIVE','B','2018-07-03','','2018-06-24','ACCEPTED',6);



INSERT INTO `iss_db`.`donations`
(`id`,
`blood_rh`,
`blood_type`,
`collection_date`,
`for_person`,
`request_date`,
`status`,
`id_donor`)
VALUES
(5,'POSITIVE','O','2018-07-03','','2018-06-24','OPEN',7);
------------------------------------------------------------------------------------------------------
#BLOOD

INSERT INTO `iss_db`.`blood`
(`blood_category`,
`bloodRh`,
`blood_type`,
`expire_date`,
`used`)
VALUES
('WHOLE','POSITIVE','AB','2018-06-30',false);
INSERT INTO `iss_db`.`blood`
(`blood_category`,
`bloodRh`,
`blood_type`,
`expire_date`,
`used`)
VALUES
('WHOLE','POSITIVE','A','2018-06-30',false);
INSERT INTO `iss_db`.`blood`
(`blood_category`,
`bloodRh`,
`blood_type`,
`expire_date`,
`used`)
VALUES
('WHOLE','POSITIVE','B','2018-06-30',false);
INSERT INTO `iss_db`.`blood`
(`blood_category`,
`bloodRh`,
`blood_type`,
`expire_date`,
`used`)
VALUES
('WHOLE','POSITIVE','O','2018-06-30',false);


INSERT INTO `iss_db`.`blood`
(`blood_category`,
`bloodRh`,
`blood_type`,
`expire_date`,
`used`)
VALUES
('WHOLE','NEGATIVE','AB','2018-06-30',false);
INSERT INTO `iss_db`.`blood`
(`blood_category`,
`bloodRh`,
`blood_type`,
`expire_date`,
`used`)
VALUES
('WHOLE','NEGATIVE','A','2018-06-30',false);
INSERT INTO `iss_db`.`blood`
(`blood_category`,
`bloodRh`,
`blood_type`,
`expire_date`,
`used`)
VALUES
('WHOLE','NEGATIVE','B','2018-06-30',false);
INSERT INTO `iss_db`.`blood`
(`blood_category`,
`bloodRh`,
`blood_type`,
`expire_date`,
`used`)
VALUES
('WHOLE','NEGATIVE','O','2018-06-30',false);


INSERT INTO `iss_db`.`blood`
(`blood_category`,
`bloodRh`,
`blood_type`,
`expire_date`,
`used`)
VALUES
('WHOLE','NEGATIVE','O','2018-06-30',true);

INSERT INTO `iss_db`.`blood`
(`blood_category`,
`bloodRh`,
`blood_type`,
`expire_date`,
`used`)
VALUES
('REDCELL','NEGATIVE','O','2018-07-30',false);
INSERT INTO `iss_db`.`blood`
(`blood_category`,
`bloodRh`,
`blood_type`,
`expire_date`,
`used`)
VALUES
('THROMBOCYTE','NEGATIVE','O','2018-07-12',false);



INSERT INTO `iss_db`.`blood`
(`blood_category`,
`bloodRh`,
`blood_type`,
`expire_date`,
`used`)
VALUES
('PLASMA','NEGATIVE','O','2018-09-12',true);

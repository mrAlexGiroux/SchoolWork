#################################################################
-- Étape 1
-- Création de la BD salaires selon le modèle
#################################################################
DROP DATABASE IF EXISTS bd_salaires;
CREATE DATABASE bd_salaires;
USE bd_salaires;

DROP TABLE IF EXISTS employes;
CREATE TABLE employes (
	id_emp INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(40) NOT NULL,
    prenom VARCHAR(40) NOT NULL,
    adresse VARCHAR(150) NOT NULL,
	code_postal CHAR(7) NOT NULL,
    telephone VARCHAR(14) NULL,
    INDEX idx_nom_prenom (nom ,prenom)
) ENGINE=INNODB;

DROP TABLE IF EXISTS poste;
CREATE TABLE poste (
	id_poste INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    poste VARCHAR(45)
)ENGINE=INNODB;

DROP TABLE IF EXISTS infoSal;
CREATE TABLE infoSal (
	id_emp INT(11) NOT NULL PRIMARY KEY,
    taux_horaire DECIMAL(5,2) NOT NULL,
    date_embauche DATE NOT NULL,
    date_dernaugmentation DATE NULL,
    id_poste INT NOT NULL,
    FOREIGN KEY fk_id_emp_employes (id_emp) REFERENCES employes (id_emp),
    FOREIGN KEY fk_infoSal_poste (id_poste) REFERENCES poste (id_poste)
)ENGINE=INNODB;

DROP TABLE IF EXISTS salaire;
CREATE TABLE salaire (
	id_salaire INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    debutSemaine DATE NOT NULL,
    nbHeure TINYINT(2) NOT NULL,
    nbHeureTempsEtDemi TINYINT(2) NOT NULL,
    nbHeureTempsDouble TINYINT(2) NOT NULL,
    paye_faite TINYINT(1) NOT NULL DEFAULT 0,
    id_emp INT(11) NOT NULL,
    INDEX idx_debut_sem (debutSemaine),
    FOREIGN KEY fk_id_emp_infoSal (id_emp) REFERENCES infoSal (id_emp)
)ENGINE=INNODB;

DROP TABLE IF EXISTS paye;
CREATE TABLE paye (
	id_depot INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date_paye DATE NOT NULL,
    revenus DECIMAL(6,2) NOT NULL,
    impot_prov DECIMAL(6,2) NOT NULL,
    impot_fed DECIMAL(6,2) NOT NULL,
    RRQ DECIMAL(6,2) NOT NULL,
    RQAP DECIMAL(6,2) NOT NULL,
    deductions DECIMAL(6,2) NOT NULL,
    montantNet DECIMAL(6,2) NOT NULL,
    id_salaire INT(11) NOT NULL,
    INDEX id_date_paye (date_paye),
    FOREIGN KEY fk_id_salaire_salaire (id_salaire) REFERENCES salaire (id_salaire)
)ENGINE=INNODB;

#################################################################
-- Étape 2
-- Peupler les données
#################################################################

-- Peupler la table employes avec GENERATEDATA
INSERT INTO employes (nom,prenom,adresse,code_postal,telephone) VALUES ("Fatima","Welch","Ap #754-5925 Urna. Road","K5N 6G2","1-583-725-8276"),("Elmo","Carpenter","Ap #642-8598 Lorem Avenue","E1X 1X6","1-162-128-4034"),("Mara","Lindsey","Ap #683-498 Lorem St.","E9K 4K9","1-672-874-2990"),("Janna","Obrien","P.O. Box 632, 3999 Sed Av.","P9Z 0B9","1-997-361-9613"),("Vivian","Ramsey","Ap #579-9955 Tristique Street","B3P 7T4","1-574-324-4888"),("Palmer","Cochran","641-1347 Magna. Road","R6M 4Y4","1-771-947-7653"),("Mary","Espinoza","2275 Ac Road","X6E 1L3","1-393-737-1022"),("Sasha","Cortez","Ap #217-1528 Cras Avenue","Y6E 6A3","1-796-672-9702"),("Silas","Pennington","822-5431 Ullamcorper St.","X0H 3E2","1-318-538-7838"),("Ferdinand","Crane","851 Malesuada St.","K5C 1J6","1-790-505-0664"),("Ulric","Golden","299-4757 Quam Street","J9V 7Z0","1-386-366-4045"),("Elmo","Carson","4194 Vitae St.","N4S 2Y3","1-958-222-9598"),("Forrest","Rodriquez","560-2928 Donec Ave","Y0E 1A4","1-882-667-9583"),("Daniel","Becker","P.O. Box 354, 6937 Facilisis Road","T4L 2A8","1-160-333-5423"),("Ava","Conner","P.O. Box 852, 6676 Phasellus Ave","B1L 0T6","1-972-472-4420"),("Wyatt","Williamson","P.O. Box 473, 3458 Donec Rd.","K2W 3X0","1-501-155-7147"),("Shelly","Foley","865-173 Nunc Road","P2Z 3S1","1-332-843-0653"),("Hermione","Ferguson","736-9123 In Road","N5V 6Z9","1-468-538-4231"),("Lee","Hines","P.O. Box 476, 5937 Arcu. Av.","B5A 9Z8","1-367-328-4744"),("Halee","Glover","Ap #171-3012 Tellus Ave","V6C 4C5","1-520-906-9764");

#################################################################
-- Étape 3
-- Peupler les données par procédures stockées
#################################################################

-- Procédure pour peupler la table poste
DELIMITER |
DROP PROCEDURE IF EXISTS peuplerTablePoste |
CREATE PROCEDURE peuplerTablePoste()
BEGIN
	INSERT INTO poste (poste) VALUES ('Directeur général'),('Comptable'),('Technicien comptable'),('Secrétaire'),('Administrateur système'),('Analyste'),('Administrateur de base de données'),('Développeur');
END |
DELIMITER ;

-- Fonction pour générer un date d'embauche entre le premier janvier 2018 et aujourd'hui
DELIMITER |
DROP FUNCTION IF EXISTS GenererDateEmbauche |
CREATE FUNCTION GenererDateEmbauche() RETURNS DATE
BEGIN
	DECLARE v_dateDebut DATE;
    DECLARE v_DateEmbauche DATE;
    SET v_dateDebut = '2018-01-01';
    
    SET v_DateEmbauche = DATE_ADD(v_DateDebut, INTERVAL (RAND() * DATEDIFF(CURDATE(), v_dateDEbut)) DAY);
    
    RETURN v_DateEmbauche;
    
END |
DELIMITER ;

-- Procédure pour peupler InfoSal
DELIMITER |
DROP PROCEDURE IF EXISTS peuplerTableInfoSal |
CREATE PROCEDURE peuplerTableInfoSal()
BEGIN 
	DECLARE v_i INT ;
    SET v_i = 1;
    WHILE v_i <= 20 DO
    IF (v_i = 1) THEN
		INSERT INTO infoSal (id_emp, taux_horaire, date_embauche, id_poste) VALUES ( 
								(SELECT emp.id_emp FROM employes AS emp WHERE emp.id_emp = v_i),
									75,	'2018-01-01', (SELECT id_poste FROM poste WHERE poste = 'Directeur général'));
	ELSEIF (v_i = 2) THEN
		INSERT INTO infoSal (id_emp, taux_horaire, date_embauche, id_poste) VALUES ( 
						(SELECT emp.id_emp FROM employes AS emp WHERE emp.id_emp = v_i),
									45,	GenererDateEmbauche(), (SELECT id_poste FROM poste WHERE poste = 'Comptable'));
	ELSEIF (v_i = 3) THEN
		INSERT INTO infoSal (id_emp, taux_horaire, date_embauche, id_poste) VALUES ( 
							(SELECT emp.id_emp FROM employes AS emp WHERE emp.id_emp = v_i),
										30,	GenererDateEmbauche(), (SELECT id_poste FROM poste WHERE poste = 'Technicien comptable'));
	ELSEIF (v_i BETWEEN 3 AND 6) THEN
		INSERT INTO infoSal (id_emp, taux_horaire, date_embauche, id_poste) VALUES ( 
					(SELECT emp.id_emp FROM employes AS emp WHERE emp.id_emp = v_i),
							18,	GenererDateEmbauche(), (SELECT id_poste FROM poste WHERE poste = 'Secrétaire'));
	ELSEIF (v_i = 7) THEN
		INSERT INTO infoSal (id_emp, taux_horaire, date_embauche, id_poste) VALUES ( 
						(SELECT emp.id_emp FROM employes AS emp WHERE emp.id_emp = v_i),
									22,	GenererDateEmbauche(), (SELECT id_poste FROM poste WHERE poste = 'Administrateur système'));
	ELSEIF (v_i BETWEEN 7 AND 9) THEN
		INSERT INTO infoSal (id_emp, taux_horaire, date_embauche, id_poste) VALUES ( 
				(SELECT emp.id_emp FROM employes AS emp WHERE emp.id_emp = v_i),
							35,	GenererDateEmbauche(), (SELECT id_poste FROM poste WHERE poste = 'Analyste'));
	ELSEIF (v_i = 10) THEN
		INSERT INTO infoSal (id_emp, taux_horaire, date_embauche, id_poste) VALUES ( 
				(SELECT id_emp FROM employes AS emp WHERE emp.id_emp = v_i),
							40,	GenererDateEmbauche(), (SELECT id_poste FROM poste WHERE poste = 'Administrateur de base de données'));
	ELSE 
		INSERT INTO infoSal (id_emp, taux_horaire, date_embauche, id_poste) VALUES ( 
			(SELECT emp.id_emp FROM employes AS emp WHERE emp.id_emp = v_i),
						25,	GenererDateEmbauche(), (SELECT id_poste FROM poste WHERE poste LIKE 'Développeur'));
	
    END IF;
    SET v_i = v_i + 1;
    END WHILE;
    
END |
DELIMITER ;

DELIMITER |
DROP PROCEDURE IF EXISTS creationSalaire |
CREATE PROCEDURE creationSalaire(IN p_id_emp INT, IN p_DateDebutSemaine DATE, IN p_NbHeure TINYINT(2), IN p_NBHeureTempsDemi TINYINT(2), IN p_NbHeureTempsDouble TINYINT(2))
BEGIN
    
    DECLARE v_id_emp INT;
    DECLARE v_dateDebutSemaine DATE;
    DECLARE v_nbHeure TINYINT(2);
    DECLARE v_nbHeureTempsDemi TINYINT(2);
    DECLARE v_nbHeureTempsDouble TINYINT(2);
    DECLARE v_paye_faite TINYINT(1);
    DECLARE v_diffDate INT;
    DECLARE v_checkIdEmp INT;
    
    SET v_checkIdEmp = (SELECT id_emp FROM infoSal WHERE id_emp = p_id_emp);
    SET v_paye_faite = (SELECT paye_faite FROM SALAIRE WHERE id_emp = p_id_emp AND debutSemaine = p_DateDebutSemaine);
	SET v_diffDate = DATEDIFF(p_DateDebutSemaine,'2017-12-31');
    
	IF ((v_diffDate % 14) != 0) THEN
		SELECT 'Mauvaise date de debut'  AS Erreur;
	ELSEIF (DATEDIFF(p_DateDebutSemaine, '2017-12-31') < 0 ) THEN
		SELECT 'Date plus petit que la premiere date d embauche'  AS Erreur;
	ELSEIF (p_nbHeure < 0) THEN
		SELECT 'NbHeure ne peut etre plus petit que 0'  AS Erreur;
	ELSEIF (p_nbHeure > 80) THEN
		SELECT 'NbHeure plus grand que 80'  AS Erreur;
	ELSEIF (v_paye_faite = 1) THEN
		SELECT 'Paie deja faite' AS Erreur;
	ELSEIF (v_checkIdEmp IS NULL) THEN
		SELECT 'Aucun employe avec ce id' AS Erreur;
	ELSEIF (p_NBHeureTempsDemi < 0) THEN
		SELECT 'NbHeure temps et demi ne peut etre negatif' AS Erreur;
	ELSEIF (p_NbHeureTempsDouble < 0) THEN
		SELECT 'NbHeure temps double ne peut etre negatif' AS Erreur;
    ELSE
        SET v_id_emp = p_id_emp;
		SET v_dateDebutSemaine = p_DateDebutSemaine;
		SET v_nbHeure = p_NbHeure;
		SET v_nbHeureTempsDemi = p_NBHeureTempsDemi;
		SET v_nbHeureTempsDouble = p_NbHeureTempsDouble;
        
        INSERT INTO salaire (id_emp, debutSemaine, nbHeure, nbHeureTempsEtDemi, nbHeureTempsDouble)
						VALUES (v_id_emp, v_dateDebutSemaine, v_nbHeure, v_nbHeureTempsDemi, v_nbHeureTempsDouble);
		UPDATE salaire SET paye_faite = 1 WHERE id_emp = v_id_emp AND debutSemaine = v_dateDebutSemaine;
    END IF;
END |
DELIMITER ;

DELIMITER |
DROP TRIGGER IF EXISTS after_insert_salaire |
CREATE TRIGGER after_insert_salaire AFTER INSERT
ON salaire FOR EACH ROW
BEGIN
	DECLARE v_tauxHoraire DECIMAL(5,2);
	DECLARE v_datePaye DATE;
	DECLARE v_revenus DECIMAL(6,2);
    DECLARE v_impot_prov DECIMAL(6,2);
    DECLARE v_impot_fed DECIMAL(6,2);
    DECLARE v_RRQ DECIMAL(6,2);
    DECLARE v_RQAP DECIMAL(6,2);
    DECLARE v_deductions DECIMAL(6,2);
    DECLARE v_revenuNet DECIMAL(6,2);
    SELECT taux_horaire INTO v_tauxHoraire FROM infoSal AS info WHERE info.id_emp = NEW.id_emp;
    
    SET v_DatePaye = DATE_ADD(NEW.debutSemaine , INTERVAL 14 DAY);
	SET v_revenus = (v_tauxHoraire * NEW.nbHeure) + ((v_tauxHoraire * 1.5) * NEW.nbHeureTempsEtDemi) + ((v_tauxHoraire * 2) * NEW.nbHeureTempsDouble);
    SET v_impot_prov = v_revenus * 0.20;
    SET v_impot_fed = v_revenus * 0.17;
    SET v_RRQ = v_revenus * 0.0108;
    SET v_RQAP = v_revenus * 0.00548;
    SET v_deductions = v_impot_prov + v_impot_fed + v_RRQ + v_RQAP;
    SET v_revenuNet = v_revenus - v_deductions;
	IF (NEW.paye_faite = 0) THEN
		INSERT INTO paye (date_paye, revenus, impot_prov, impot_fed, RRQ, RQAP, deductions, montantNet, id_salaire) 
					VALUES (v_datePaye, v_revenus, v_impot_prov, v_impot_fed, v_RRQ, v_RQAP, v_deductions, v_revenuNet, NEW.id_salaire);
    END IF;
END |
DELIMITER ;

#################################################################
-- Étape 3
-- Test des procédures
#################################################################
-- Test de la procédure peuplerTablePoste
CALL peuplerTablePoste();
SELECT * FROM poste;

-- Test de la procédure peuplerTableInfoSal
CALL peuplerTableInfoSal();
SELECT * FROM infoSal;

#	 	 Test réussi 		  #
###############################

-- Premier test de la créationSalaire et vérifier que la donnée est bien inserée
CALL creationSalaire(1,'2018-01-14', 40, 2, 1);
SELECT * FROM salaire;
SELECT * FROM paye;

-- Test réussi avec d'autre paramètre que la premiere
CALL creationSalaire(2,'2018-01-28', 35, 0, 0);
SELECT * FROM salaire;
SELECT * FROM paye;

-- Test que la premiere paye qui est fait ne marchera pas a nouveau
CALL creationSalaire(1,'2018-01-14', 80, 2, 1);
SELECT * FROM salaire;
SELECT * FROM paye;

# Test des paramètres limites #
###############################
-- Test avec nombres d'heure < 80
CALL creationSalaire(3,'2018-01-14', 82, 2, 1);
SELECT * FROM paye;

-- Test avec nombres d'heure temps demi plus < 0
CALL creationSalaire(3,'2018-01-14', 80, -1, 0);

-- Test avec nombres d'heure temps double < 0
CALL creationSalaire(3,'2018-01-14', 80, 0, -1);

SELECT * FROM salaire;
SELECT * FROM paye;

# 		Test des dates		  #
###############################
-- Test avec une date entre deux date de paye
CALL creationSalaire(4,'2018-01-22', 80, 2, 1);

-- Test avec une date inferieur au 31 decembre 2017
CALL creationSalaire(4,'2017-12-17', 80, 2, 1);
SELECT * FROM salaire;
SELECT * FROM paye;

-- Test avec un mauvais id d'employe
CALL creationSalaire(22,'2018-01-14', 80, 2, 1);
SELECT * FROM salaire;
SELECT * FROM paye;







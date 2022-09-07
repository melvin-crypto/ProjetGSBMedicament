-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : ven. 25 mars 2022 à 17:46
-- Version du serveur :  5.7.32
-- Version de PHP : 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `presentation_medicament3`
--

-- --------------------------------------------------------

--
-- Structure de la table `composant`
--

CREATE TABLE `composant` (
  `cmpCode` int(4) NOT NULL,
  `libelle` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `composant`
--

INSERT INTO `composant` (`cmpCode`, `libelle`) VALUES
(1, 'Magnesium stearate'),
(2, 'Bleu patenté V'),
(3, 'Talc'),
(4, 'Gélatine'),
(5, 'Amidon de mais'),
(6, 'gomme arabique'),
(7, 'Salbutamol');

-- --------------------------------------------------------

--
-- Structure de la table `constituer`
--

CREATE TABLE `constituer` (
  `depotLegal` int(10) NOT NULL,
  `cmpCode` int(4) NOT NULL,
  `quantite` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `constituer`
--

INSERT INTO `constituer` (`depotLegal`, `cmpCode`, `quantite`) VALUES
(124785692, 1, 10),
(487661349, 1, 10),
(754125475, 1, 10),
(469874216, 1, 10),
(124785692, 2, 10),
(754816534, 1, 10),
(689754613, 1, 10),
(987613425, 1, 10),
(675142384, 1, 10),
(365748542, 1, 20),
(325417856, 2, 10),
(487661349, 3, 20),
(325417856, 3, 30),
(689754613, 3, 10),
(675142384, 3, 30),
(469874216, 4, 10),
(325417856, 4, 10),
(689754613, 4, 20),
(469874216, 5, 20),
(325417856, 5, 20),
(487661349, 6, 20),
(689754613, 6, 25),
(754816534, 6, 15),
(469874216, 3, 10);

-- --------------------------------------------------------

--
-- Structure de la table `formuler`
--

CREATE TABLE `formuler` (
  `depotLegal` int(10) NOT NULL,
  `preCode` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `formuler`
--

INSERT INTO `formuler` (`depotLegal`, `preCode`) VALUES
(124785692, 1),
(124785692, 2),
(124785692, 3),
(124785692, 5),
(124785692, 6),
(325417856, 1),
(325417856, 5),
(365748542, 5),
(365748542, 6),
(469874216, 2),
(469874216, 4),
(469874216, 5),
(469874216, 6),
(487661349, 2),
(487661349, 6),
(675142384, 6),
(689754613, 3),
(689754613, 6),
(754125475, 1),
(754125475, 3),
(754125475, 5),
(754125475, 6),
(754816534, 4),
(754816534, 6),
(987613425, 6);

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

CREATE TABLE `inscription` (
  `id` int(6) NOT NULL,
  `nom` varchar(24) NOT NULL,
  `prenom` varchar(24) NOT NULL,
  `sexe` varchar(24) NOT NULL,
  `adresse` varchar(24) NOT NULL,
  `codePostal` int(6) NOT NULL,
  `ville` varchar(24) NOT NULL,
  `telephone` int(11) NOT NULL,
  `adresseMail` varchar(32) NOT NULL,
  `mdp` varchar(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`id`, `nom`, `prenom`, `sexe`, `adresse`, `codePostal`, `ville`, `telephone`, `adresseMail`, `mdp`) VALUES
(2, 'Pierrot', 'Paul', 'Homme', '8 rue du roi', 75019, 'Paris', 628737738, 'Paul@gmail.com', 'a'),
(3, 'Dupont', 'Charles', 'Homme', '25 avenue de la maison', 75010, 'Paris', 627372832, 'Charles@gmail.com', 'ezfifyh67'),
(4, 'Danny', 'Lucie', 'Femme', '76 rue de l\'Alma', 13010, 'Marseille', 716253728, 'Lucie@gmail.com', 'Aogtgjo'),
(5, 'Somo', 'Mathilde', 'Femme', '35 Boulevard de l\'Alsace', 69030, 'Lyon', 612345678, 'Mathilde@gmail.com', 'hHGgJHH'),
(6, 'Dula', 'Clara', 'Femme', '62 rue raspail', 77300, 'Lille', 726152637, 'Clara@gmail.com', 'jdjd566'),
(7, 'Sillam', 'Anael', 'Femme', '16 rue etienne marcel', 93500, 'pantin', 633436272, 'anaelsillam@gmail.com', 'aa');

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

CREATE TABLE `medicament` (
  `depotLegal` int(10) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `code` int(3) NOT NULL,
  `composition` varchar(255) NOT NULL,
  `effets` varchar(255) NOT NULL,
  `contreIndication` varchar(255) NOT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `medicament`
--

INSERT INTO `medicament` (`depotLegal`, `nom`, `code`, `composition`, `effets`, `contreIndication`, `prix`) VALUES
(124785692, 'Doliprane', 1, 'Amidon de riz , Glycérol distéarate , Magnésium stéarate , Composition de l\'enveloppe de la gélule : Gélatine , Titane dioxyde , Jaune de quinoléine , Fer oxyde rouge , Bleu patenté V', 'Réaction d\'hypersensibilité\r\nChoc anaphylactique\r\nOedème de Quincke\r\nErythème cutané\r\nUrticaire\r\nRash cutané\r\nRéaction cutanée', 'Insuffisance hépatocellulaire sévère\r\nEnfant avant 6 ans\r\nConsommation d\'alcool\r\nHypersensibilité à la substance active ou à l\'un des excipients\r\nInsuffisance hépatocellulaire sévère.\r\nEnfant de moins de 6 ans, en raison des risques de fausse route', 2.18),
(325417856, 'Imodium', 5, 'Amidon de maïs, Talc, Magnésium stéarate, Composition de l\'enveloppe de la gélule : Gélatine, Titane dioxyde, Erythrosine, Fer oxyde jaune, Bleu patenté V, Fer oxyde noir', 'Céphalée\r\nSensation vertigineuse\r\nSomnolence\r\nPerte de conscience\r\nDiminution du niveau de conscience\r\nHypertonie\r\nTrouble de la coordination', 'Dysenterie aiguë avec présence de sang dans les selles et fièvre\r\nPoussée aiguë de rectocolite hémorragique\r\nColite pseudomembraneuse associée aux antibiotiques\r\nEnfant de moins de 8 ans\r\nIntolérance au lactose\r\nGrossesse\r\nAllaitement', 2.25),
(365748542, 'Spedifen', 10, 'Arginine, Sodium bicarbonate, Crospovidone, Magnésium stéarate, Eau purifiée', 'Thrombopénie\r\nAgranulocytose\r\nAnémie aplasique\r\nAnémie\r\nAnémie hémolytique\r\nRéaction allergique\r\nAnaphylaxie', 'Hypersensibilité ibuprofène\r\nAntécédent de réaction d\'hypersensibilité à un AINS ou à l\'acide acétylsalicylique\r\nAntécédent d\'hémorragie ou de perforation digestive par AINS\r\nHémorragie gastro-intestinale, cérébrovasculaire\r\nSaignement évolutif ', 2.2),
(469874216, 'Levothyrox', 4, 'Lévothyroxine sodique, Mannitol , Amidon de maïs , Gélatine , Croscarmellose sodique , Magnésium stéarate , Citrique acide anhydre', 'Aggravation de cardiopathie\r\nAggravation de l\'insuffisance cardiaque\r\nAggravation d\'angor\r\nAggravation d\'un trouble du rythme\r\nTachycardie\r\nHyperthyroïdie\r\nTremblement', 'Syndrome coronaire aigu\r\nMyocardite aiguë\r\nEnfant de moins de 6 ans\r\nCardiopathie décompensée\r\nCoronaropathie non contrôlée\r\nTroubles du rythme non contrôlés', 3.57),
(487661349, 'Efferalgan', 2, 'Sorbitol , Talc , Méthacrylate basique copolymère , Magnésium oxyde léger , Carmellose sodique , Sucralose , Magnésium stéarate , Hypromellose , Stéarique acide , Sodium laurylsulfate , Titane dioxyde ,Talc,Arôme vanille, Arôme fraise', 'Anémie\r\nAnémie non hémolytique\r\nDépression de la moelle osseuse\r\nThrombopénie\r\nLeucopénie\r\nNeutropénie\r\nOedème', 'Insuffisance hépatocellulaire sévère\r\nMaladie hépatique décompensée\r\nIntolérance au fructose\r\nMalabsorption du glucose-galactose\r\nHypersensibilité à la substance active ou à l\'un des excipients', 2.9),
(675142384, 'Tahor', 9, 'Noyau du comprimé : Calcium carbonate, Cellulose microcristalline, Croscarmellose sodique, Polysorbate 80, Hydroxypropylcellulose, Magnésium stéarate, Pelliculage : Hypromellose, Macrogol 8000, Titane dioxyde, Talc', 'Nasopharyngite\r\nThrombocytopénie\r\nRéaction allergique\r\nAnaphylaxie\r\nHyperglycémie\r\nHypoglycémie\r\nPrise de poids', 'Hypersensibilité atorvastatine\r\nAffection hépatique évolutive\r\nElévation prolongée et inexpliquée des transaminases > 3 N\r\nGrossesse\r\nAllaitement\r\nAbsence de contraception féminine efficace\r\nCPK musculaire > 5 N', 5.09),
(689754613, 'Spasfon', 7, 'Saccharose, Polyvinyle acétate, Stéarique acide, Magnésium stéarate, Enrobage : Polyvinyle acétate, Talc, Gomme arabique, Gélatine, Titane dioxyde, Erythrosine, Cire de carnauba', 'Eruption cutanée\r\nUrticaire\r\nPrurit cutané\r\nOedème de Quincke\r\nChoc anaphylactique\r\nHypotension artérielle\r\nPustulose exanthématique aiguë généralisée', 'Hypersensibilité phloroglucinol\r\nAllergie amidon de blé\r\nIntolérance au galactose\r\nSyndrome de malabsorption du glucose\r\nSyndrome de malabsorption du galactose\r\nDéficit en lactase\r\nIntolérance au fructose', 2.14),
(754125475, 'Dafalgan', 3, 'Azorubine, Magnésium stéarate, Composition de la gélule n°0 : Gélatine, Titane dioxyde', 'Réaction d\'hypersensibilité\r\nChoc anaphylactique\r\nHypotension\r\nOedème de Quincke\r\nErythème cutané\r\nUrticaire allergique\r\nRash cutané', 'Insuffisance hépatocellulaire sévère\r\nMaladie hépatique décompensée\r\nEnfant avant 6 ans\r\nHypersensibilité à la substance active ou à l\'un des excipients,\r\nInsuffisance hépatocellulaire sévère ou maladie active du foie décompensée.', 1.16),
(754816534, 'Kardegic', 6, 'Glycine', 'Syndrome hémorragique\r\nHématome\r\nHémorragie urogénitale\r\nEpistaxis\r\nGingivorragie\r\nPurpura\r\nAugmentation du temps de saignement', 'Grossesse à partir du 6ème mois\r\nAntécédent d\'asthme associé à la prise d\'AINS\r\nAntécédent d\'asthme associé à la prise d\'aspirine\r\nUlcère gastroduodénal en évolution\r\nMaladie hémorragique\r\nMastocytose\r\nRisque hémorragique', 1.79),
(987613425, 'Isimig', 8, 'Cellulose microcristalline, Magnésium stéarate, carboxyméthylamidon sodique (type A), Silice colloïdale anhydre, Opadry blanc : Titane dioxyde, Hypromellose, Macrogol 3000, Triacétine', 'Lymphadénopathie\r\nRéaction d\'hypersensibilité\r\nRéaction cutanée allergique\r\nAngioedème\r\nAnaphylaxie\r\nDéshydratation\r\nHypoglycémie', 'Antécédent d\'infarctus du myocarde\r\nPathologie cardiaque ischémique\r\nVasospasme coronarien\r\nAngor de Prinzmetal\r\nPathologie vasculaire périphérique\r\nSymptôme de pathologie cardiaque ischémique\r\nSignes compatibles avec une pathologie cardiaque ischémique', 3.69);

-- --------------------------------------------------------

--
-- Structure de la table `presentation`
--

CREATE TABLE `presentation` (
  `preCode` int(2) NOT NULL,
  `libelle` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `presentation`
--

INSERT INTO `presentation` (`preCode`, `libelle`) VALUES
(1, 'Gélule'),
(2, 'Granulé'),
(3, 'Suppositoire'),
(4, 'poudre'),
(5, 'sirop'),
(6, 'comprimé');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `composant`
--
ALTER TABLE `composant`
  ADD PRIMARY KEY (`cmpCode`);

--
-- Index pour la table `constituer`
--
ALTER TABLE `constituer`
  ADD KEY `cmpCode` (`cmpCode`),
  ADD KEY `depotLegal` (`depotLegal`);

--
-- Index pour la table `formuler`
--
ALTER TABLE `formuler`
  ADD KEY `depotLegal` (`depotLegal`),
  ADD KEY `preCode` (`preCode`);

--
-- Index pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `medicament`
--
ALTER TABLE `medicament`
  ADD PRIMARY KEY (`depotLegal`);

--
-- Index pour la table `presentation`
--
ALTER TABLE `presentation`
  ADD PRIMARY KEY (`preCode`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `inscription`
--
ALTER TABLE `inscription`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `constituer`
--
ALTER TABLE `constituer`
  ADD CONSTRAINT `constituer_ibfk_1` FOREIGN KEY (`cmpCode`) REFERENCES `composant` (`cmpCode`),
  ADD CONSTRAINT `constituer_ibfk_2` FOREIGN KEY (`depotLegal`) REFERENCES `medicament` (`depotLegal`);

--
-- Contraintes pour la table `formuler`
--
ALTER TABLE `formuler`
  ADD CONSTRAINT `formuler_ibfk_1` FOREIGN KEY (`depotLegal`) REFERENCES `medicament` (`depotLegal`),
  ADD CONSTRAINT `formuler_ibfk_2` FOREIGN KEY (`preCode`) REFERENCES `presentation` (`preCode`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

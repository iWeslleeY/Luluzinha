-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 20-Mar-2020 às 14:37
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `luluzinha`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `atividades`
--

CREATE TABLE `atividades` (
  `id` int(11) NOT NULL,
  `nm_demanda` varchar(50) NOT NULL,
  `dt_anotacao` datetime NOT NULL,
  `anotacao` text NOT NULL,
  `responsavel` varchar(30) NOT NULL,
  `situacao` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `atividades`
--

INSERT INTO `atividades` (`id`, `nm_demanda`, `dt_anotacao`, `anotacao`, `responsavel`, `situacao`) VALUES
(12, 'teste1', '2020-03-26 00:00:00', 'trtrthythtyjtyjujyuj yuj yujyuj yuj', 'Ana', ''),
(13, 'teste2', '2020-03-23 00:00:00', 'teste da situacao', 'Luana', 'Feito');

-- --------------------------------------------------------

--
-- Estrutura da tabela `centro_custo`
--

CREATE TABLE `centro_custo` (
  `id` int(11) NOT NULL,
  `num_registro` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `id_treinamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `demandas`
--

CREATE TABLE `demandas` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `vagas` varchar(11) DEFAULT NULL,
  `justificativa` text DEFAULT NULL,
  `prioridade` varchar(30) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `responsavel` varchar(30) DEFAULT NULL,
  `endereco` text DEFAULT NULL,
  `horario` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `dt_inicio` date DEFAULT NULL,
  `dt_fim` date DEFAULT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fim` time NOT NULL,
  `coordenador` varchar(100) DEFAULT NULL,
  `gerente` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `demandas`
--

INSERT INTO `demandas` (`id`, `nome`, `vagas`, `justificativa`, `prioridade`, `status`, `responsavel`, `endereco`, `horario`, `dt_inicio`, `dt_fim`, `hora_inicio`, `hora_fim`, `coordenador`, `gerente`) VALUES
(16, 'teste1', '123', 'teste1', 'Media', 'Em andamento', 'teste1', 'teste1', '2020-03-11 14:26:55', '2020-03-12', '2020-03-16', '00:25:00', '10:25:00', 'teste1', 'teste1'),
(17, 'teste2', '312', 'teste2', 'Alta', 'Em andamento', 'teste2', 'teste2', '2020-03-11 14:27:58', '2020-03-12', '2020-03-13', '13:27:00', '09:27:00', 'teste2', 'teste2'),
(18, 'teste3', '312', 'teste3', 'Alta', 'Em andamento', 'teste3', 'teste3', '2020-03-11 14:28:24', '2020-03-12', '2020-03-13', '13:27:00', '09:27:00', 'teste3', 'teste3'),
(19, 'asdppimasd', '123', 'asdsad', 'Baixa', 'Em andamento', 'asld,pas,d', 'pas,dpasd', '2020-03-13 12:33:25', '2020-03-19', '2020-03-25', '23:32:00', '10:32:00', 'asdasd', 'as,das,d');

-- --------------------------------------------------------

--
-- Estrutura da tabela `teste`
--

CREATE TABLE `teste` (
  `teste_nome` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `atividades`
--
ALTER TABLE `atividades`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nm_demanda` (`nm_demanda`);

--
-- Índices para tabela `centro_custo`
--
ALTER TABLE `centro_custo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_treinamento` (`id_treinamento`);

--
-- Índices para tabela `demandas`
--
ALTER TABLE `demandas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `atividades`
--
ALTER TABLE `atividades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de tabela `centro_custo`
--
ALTER TABLE `centro_custo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `demandas`
--
ALTER TABLE `demandas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `centro_custo`
--
ALTER TABLE `centro_custo`
  ADD CONSTRAINT `centro_custo_ibfk_1` FOREIGN KEY (`id_treinamento`) REFERENCES `demandas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

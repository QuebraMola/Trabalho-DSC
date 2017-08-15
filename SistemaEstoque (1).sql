-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 15-Ago-2017 às 11:50
-- Versão do servidor: 5.7.19-0ubuntu0.16.04.1
-- PHP Version: 7.0.18-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `SistemaEstoque`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nomeCompleto` varchar(150) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `dataNascimento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`id`, `nomeCompleto`, `cpf`, `endereco`, `telefone`, `dataNascimento`) VALUES
(1, 'Junior Pereira', '11756574685', 'Rua X , 145', '38 991695290', '1993-03-20'),
(3, 'kelvin', '11756574685', 'rua x', '3891929292929', '1989-12-12'),
(4, 'João da Silva', '13740757876', 'rua f', '38991234829', '1998-12-02'),
(5, 'Lucas Fernandes', '59329358128', 'rua j', '389291029293', '2000-10-08');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedores`
--

CREATE TABLE `fornecedores` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `cnpj` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecedores`
--

INSERT INTO `fornecedores` (`id`, `nome`, `telefone`, `cnpj`) VALUES
(14, 'Molas Gonçalves Ltda', '36218786', '54137524000158'),
(15, 'Construtora dos Parceiros', '3836215456', '11689337000174'),
(16, 'Gigantes de Aço', '3836213445', '80165926000176');

-- --------------------------------------------------------

--
-- Estrutura da tabela `itensvenda`
--

CREATE TABLE `itensvenda` (
  `id` int(11) NOT NULL,
  `produto` int(11) NOT NULL,
  `venda` int(11) NOT NULL,
  `qtd` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `id` int(11) NOT NULL,
  `descricao` varchar(150) NOT NULL,
  `fornecedor` int(11) NOT NULL,
  `valorCompra` decimal(9,2) NOT NULL,
  `porcentagemLucro` int(11) NOT NULL,
  `qtd` int(11) NOT NULL,
  `validade` date NOT NULL,
  `valorFinal` decimal(9,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`id`, `descricao`, `fornecedor`, `valorCompra`, `porcentagemLucro`, `qtd`, `validade`, `valorFinal`) VALUES
(4, 'Mola de Carro (Uno)', 14, '300.00', 20, 50, '2020-12-12', '0.00'),
(5, 'Cimento Montes Claros', 15, '25.00', 15, 50, '2020-05-12', '0.00'),
(6, 'Aço Valiriano', 16, '12000.00', 40, 8, '3000-12-12', '16800.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nomeCompleto` varchar(150) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `nomeUsuario` varchar(150) NOT NULL,
  `senha` varchar(150) NOT NULL,
  `tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `nomeCompleto`, `cpf`, `nomeUsuario`, `senha`, `tipo`) VALUES
(1, 'administrador', '11756574685', 'admin', 'admin', 1),
(2, 'josue de souza ', '84122112273', 'juniormundo', '12345', 1),
(3, 'João Pedro', '76228875108', 'Quebra-Mola', '12345', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendas`
--

CREATE TABLE `vendas` (
  `id` int(11) NOT NULL,
  `cliente` int(11) DEFAULT NULL,
  `funcionario` int(11) NOT NULL,
  `valorVenda` decimal(9,2) NOT NULL,
  `dataVenda` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fornecedores`
--
ALTER TABLE `fornecedores`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `itensvenda`
--
ALTER TABLE `itensvenda`
  ADD PRIMARY KEY (`id`,`produto`,`venda`),
  ADD KEY `produto` (`produto`),
  ADD KEY `venda` (`venda`);

--
-- Indexes for table `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fornecedor` (`fornecedor`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vendas`
--
ALTER TABLE `vendas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente` (`cliente`),
  ADD KEY `funcionario` (`funcionario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `fornecedores`
--
ALTER TABLE `fornecedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `itensvenda`
--
ALTER TABLE `itensvenda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `produtos`
--
ALTER TABLE `produtos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `vendas`
--
ALTER TABLE `vendas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `itensvenda`
--
ALTER TABLE `itensvenda`
  ADD CONSTRAINT `itensvenda_ibfk_1` FOREIGN KEY (`produto`) REFERENCES `produtos` (`id`),
  ADD CONSTRAINT `itensvenda_ibfk_2` FOREIGN KEY (`venda`) REFERENCES `vendas` (`id`);

--
-- Limitadores para a tabela `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `produtos_ibfk_1` FOREIGN KEY (`fornecedor`) REFERENCES `fornecedores` (`id`);

--
-- Limitadores para a tabela `vendas`
--
ALTER TABLE `vendas`
  ADD CONSTRAINT `vendas_ibfk_1` FOREIGN KEY (`cliente`) REFERENCES `clientes` (`id`),
  ADD CONSTRAINT `vendas_ibfk_2` FOREIGN KEY (`funcionario`) REFERENCES `usuarios` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

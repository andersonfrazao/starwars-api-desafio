CREATE TABLE `starwars`.`usuario` (
  `idusuario` INT NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(100) NULL,
  `idperfil` INT NULL,
  PRIMARY KEY (`idusuario`),
  INDEX `perfil_idx` (`idperfil` ASC) VISIBLE,
  CONSTRAINT `perfil`
    FOREIGN KEY (`idperfil`)
    REFERENCES `starwars`.`perfil` (`idperfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Taebela responsavel por armazenar os usuarios do sistema';
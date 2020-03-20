-- banco de dados 10.4.11-MariaDB


create table treinamento(
    id int not null AUTO_INCREMENT,
    nome varchar(100)not null,
    dt_solicitacao date,
    vagas int,
    justificativa text,
    prioridade varchar(30),
    status varchar(30),
    responsavel varchar(30),
    saldo double,
    observacao text,
    enderenco text, 
    horario timestamp, 
    dt_inicio date,
    dt_fim date,
    coordenador varchar(100),
    gerente varchar(100), 
    PRIMARY KEY(id));


    create table anotacao(
        id int not null AUTO_INCREMENT,
        id_treinamento int not null,
        dt_anotacao datetime,
        anotacao text, 	                            
        responsavel varchar(30),
        PRIMARY KEY(id),
        FOREIGN KEY (id_treinamento) REFERENCES treinamento(id)
    );

create table centro_custo(
        id int not null AUTO_INCREMENT,
    	num_registro int not null,
        nome varchar(100),
        id_treinamento int not null,
   		 PRIMARY KEY(id),
        FOREIGN KEY(id_treinamento) REFERENCES treinamento(id)    
    )


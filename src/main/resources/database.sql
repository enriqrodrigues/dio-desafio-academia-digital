--COMANDOS USADOS PARA CRIAÇÃO DA TABELA NO MYSQL
create table tb_alunos (
       id bigint not null auto_increment,
        bairro varchar(255) not null,
        cpf varchar(255) not null,
        data_de_nascimento date not null,
        nome varchar(255) not null,
        primary key (id)
);

create table tb_avaliacoes (
       id bigint not null auto_increment,
        altura_atual double precision not null,
        data_da_avaliacao datetime(6) not null,
        peso_atual double precision not null,
        aluno_id bigint,
        primary key (id)
);

create table tb_matriculas (
       id bigint not null auto_increment,
        data_da_matricula datetime(6) not null,
        aluno_id bigint,
        primary key (id)
);

-- DEFININDO AS CHAVES DAS TABELAS
alter table tb_alunos
       add constraint UK_tb_alunos_cpf unique (cpf);

alter table tb_avaliacoes
       add constraint FK_tb_avaliacoes_tb_alunos
       foreign key (aluno_id)
       references tb_alunos (id);

alter table tb_matriculas
       add constraint UK_tb_matricula_aluno unique (aluno_id);

alter table tb_matriculas
       add constraint FK_tb_matriculas_tb_alunos
       foreign key (aluno_id)
       references tb_alunos (id);

#--INSERT NA TABELA DE ALUNOS
INSERT INTO tb_alunos (bairro, cpf, data_de_nascimento, nome)
    VALUES ('Casa Amarela', '646.151.240-31', '1985-10-01', 'João da Silva');
INSERT INTO tb_alunos (bairro, cpf, data_de_nascimento, nome)
    VALUES ('Várzea', '493.821.620-54', '1986-05-17', 'José Pereira');
INSERT INTO tb_alunos (bairro, cpf, data_de_nascimento, nome)
    VALUES ('Casa Forte', '239.939.630-83', '1989-11-11', 'Ana Machado');
INSERT INTO tb_alunos (bairro, cpf, data_de_nascimento, nome)
    VALUES ('Beberibe', '656.951.210-27', '1991-12-21', 'Marcos Rocha');
INSERT INTO tb_alunos (bairro, cpf, data_de_nascimento, nome)
    VALUES ('Vasco da Gama', '102.380.600-20', '2002-05-08', 'Alice Sampaio');

#--INSERT NA TABELA DE AVALIAÇÕES
INSERT INTO tb_avaliacoes (altura_atual, data_da_avaliacao, peso_atual, aluno_id)
    VALUES ('175', '2022-07-30 15:32:15.078014', '75', '1');
INSERT INTO tb_avaliacoes (altura_atual, data_da_avaliacao, peso_atual, aluno_id)
    VALUES ('174', '2022-07-30 15:32:15.078014', '78', '2');
INSERT INTO tb_avaliacoes (altura_atual, data_da_avaliacao, peso_atual, aluno_id)
    VALUES ('169', '2022-07-30 15:32:15.078014', '65', '3');
INSERT INTO tb_avaliacoes (altura_atual, data_da_avaliacao, peso_atual, aluno_id)
    VALUES ('178', '2022-07-30 15:32:15.078014', '78', '4');
INSERT INTO tb_avaliacoes (altura_atual, data_da_avaliacao, peso_atual, aluno_id)
    VALUES ('170', '2022-07-30 15:32:15.078014', '65', '5');

#--INSERT NA TABELA DE MATRÍCULAS
INSERT INTO tb_matriculas (data_da_matricula, aluno_id)
    VALUES ('2022-07-30 15:32:15.078014', '1');
INSERT INTO tb_matriculas (data_da_matricula, aluno_id)
    VALUES ('2022-07-30 15:32:15.078014', '2');
INSERT INTO tb_matriculas (data_da_matricula, aluno_id)
    VALUES ('2022-07-30 15:32:15.078014', '3');
INSERT INTO tb_matriculas (data_da_matricula, aluno_id)
    VALUES ('2022-07-30 15:32:15.078014', '4');
INSERT INTO tb_matriculas (data_da_matricula, aluno_id)
    VALUES ('2022-07-30 15:32:15.078014', '5');

/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  03/01/2019 15:35:34                      */
/*==============================================================*/


drop table if exists ADMINISTRATEUR;

drop table if exists ALBUM;

drop table if exists ARTISTE;

drop table if exists CHANSON;

drop table if exists CLIENT;

drop table if exists GENRE;

/*==============================================================*/
/* Table : ADMINISTRATEUR                                       */
/*==============================================================*/
create table ADMINISTRATEUR
(
   IDROOT               int not null auto_increment,
   USERNAME             varchar(150),
   PASSWORD             varchar(250),
   MAIL                 varchar(150),
   primary key (IDROOT)
);

/*==============================================================*/
/* Table : ALBUM                                                */
/*==============================================================*/
create table ALBUM
(
   REFALBUM             int not null auto_increment,
   REFARTISTE           int not null,
   DESIGNATION          varchar(150),
   DATESORTIE           date,
   IMAGE                longblob,
   primary key (REFALBUM)
);

/*==============================================================*/
/* Table : ARTISTE                                              */
/*==============================================================*/
create table ARTISTE
(
   REFARTISTE           int not null auto_increment,
   DESIGNATION          varchar(150),
   IMAGE                longblob,
   primary key (REFARTISTE)
);

/*==============================================================*/
/* Table : CHANSON                                              */
/*==============================================================*/
create table CHANSON
(
   REFCHANSON           int not null auto_increment,
   REFGENRE             int not null,
   REFALBUM             int not null,
   TITRE                varchar(150),
   DATESORTIE           date,
   COMMENT              text,
   COMPOSER             varchar(250),
   PUBLISHER            varchar(150),
   COPYRIGHT            varchar(250),
   URL                  varchar(250),
   primary key (REFCHANSON)
);

/*==============================================================*/
/* Table : CLIENT                                               */
/*==============================================================*/
create table CLIENT
(
   REFCLIENT            char(10),
   USERNAME             varchar(150),
   PASSWORD             varchar(250),
   EMAIL                varchar(150)
);

/*==============================================================*/
/* Table : GENRE                                                */
/*==============================================================*/
create table GENRE
(
   REFGENRE             int not null auto_increment,
   DESIGNATION          varchar(150),
   primary key (REFGENRE)
);

alter table ALBUM add constraint FK_ALBUMARTISTE foreign key (REFARTISTE)
      references ARTISTE (REFARTISTE) on delete restrict on update restrict;

alter table CHANSON add constraint FK_CDA foreign key (REFALBUM)
      references ALBUM (REFALBUM) on delete restrict on update restrict;

alter table CHANSON add constraint FK_GENREMUSICAL foreign key (REFGENRE)
      references GENRE (REFGENRE) on delete restrict on update restrict;


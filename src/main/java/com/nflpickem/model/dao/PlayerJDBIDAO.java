package com.nflpickem.model.dao;

import com.nflpickem.model.Player;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.util.Collection;

public interface PlayerJDBIDAO {

    public static final String TABLE_NAME = "player";

    @SqlUpdate("CREATE TABLE `player` (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `version` bigint(20) NOT NULL,\n" +
            "  `account_expired` bit(1) NOT NULL,\n" +
            "  `account_locked` bit(1) NOT NULL,\n" +
            "  `address1` varchar(255) DEFAULT NULL,\n" +
            "  `address2` varchar(255) DEFAULT NULL,\n" +
            "  `city` varchar(255) DEFAULT NULL,\n" +
            "  `default_pick` varchar(255) NOT NULL,\n" +
            "  `email` varchar(255) NOT NULL,\n" +
            "  `enabled` bit(1) NOT NULL,\n" +
            "  `first_name` varchar(255) NOT NULL,\n" +
            "  `last_name` varchar(255) NOT NULL,\n" +
            "  `password` varchar(255) NOT NULL,\n" +
            "  `password_expired` bit(1) NOT NULL,\n" +
            "  `state` varchar(255) DEFAULT NULL,\n" +
            "  `username` varchar(255) NOT NULL,\n" +
            "  `zip` varchar(255) DEFAULT NULL,\n" +
            "  `app_sessionid` varchar(255) DEFAULT NULL,\n" +
            "  `device_id` varchar(255) DEFAULT NULL,\n" +
            "  `registration_key` varchar(255) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `email` (`email`)\n" +
            ") ENGINE=MyISAM AUTO_INCREMENT=179 DEFAULT CHARSET=utf8;\n")
    void createPlayerTable();

    @SqlQuery("SELECT * FROM player;")
    Collection<Player> getAll();

    @SqlQuery("SELECT * FROM player WHERE id = :id")
    Player getById(@Bind("id") long id);
}
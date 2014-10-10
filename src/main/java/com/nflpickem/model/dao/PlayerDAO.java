package com.nflpickem.model.dao;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.nflpickem.database.transaction.Transactional;
import com.nflpickem.model.Player;
import org.jooq.Record;
import org.jooq.Result;
import org.skife.jdbi.v2.TransactionIsolationLevel;

import java.util.List;

import static com.nflpickem.database.schema.Tables.PLAYER;

public class PlayerDAO extends AbstractDAO {

    @Transactional(TransactionIsolationLevel.REPEATABLE_READ)
    public List<Player> getPlayers() {
        Result<? extends Record> results = jooq().select(
                PLAYER.ID,
                PLAYER.FIRST_NAME,
                PLAYER.LAST_NAME,
                PLAYER.EMAIL,
                PLAYER.USERNAME)
                .from(PLAYER).fetch();

        return Lists.transform(results, new PlayersFromRecord());
    }

    @Transactional(TransactionIsolationLevel.REPEATABLE_READ)
    public Optional<Player> getPlayerById(Long playerId) {
        Result<? extends Record> results = jooq().select(
                PLAYER.ID,
                PLAYER.FIRST_NAME,
                PLAYER.LAST_NAME,
                PLAYER.EMAIL,
                PLAYER.USERNAME)
                .from(PLAYER)
                .where(PLAYER.ID.eq(playerId))
                .fetch();

        List<Player> players = Lists.transform(results, new PlayersFromRecord());
        return (players.size() == 0)
                ? Optional.<Player>absent()
                : Optional.of(players.get(0));
    }

    private static class PlayersFromRecord implements Function<Record, Player> {
        @Override
        public Player apply(Record record) {
            return new Player()
                    .withEmail(record.getValue(PLAYER.EMAIL))
                    .withFirstName(record.getValue(PLAYER.FIRST_NAME))
                    .withLastName(record.getValue(PLAYER.LAST_NAME))
                    .withId(record.getValue(PLAYER.ID))
                    .withUsername(record.getValue(PLAYER.USERNAME));
        }
    }

}

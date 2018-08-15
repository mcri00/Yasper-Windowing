package it.polimi.yasper.core.quering.response;

import it.polimi.yasper.core.quering.querying.ContinuousQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class InstantaneousResponse implements Response {

    private String id;
    private long creation_timestamp, cep_timestamp;
    private ContinuousQuery query;

    @Override
    public long getCreationTime() {
        return creation_timestamp;
    }

    @Override
    public String getQueryString() {
        return query.toString();
    }

    public abstract InstantaneousResponse difference(InstantaneousResponse r);

    public abstract InstantaneousResponse intersection(InstantaneousResponse new_response);
}

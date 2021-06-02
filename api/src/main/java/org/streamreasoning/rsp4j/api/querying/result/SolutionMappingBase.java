package org.streamreasoning.rsp4j.api.querying.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.rdf.api.Triple;

import java.util.function.Function;

@Getter
@AllArgsConstructor
public abstract class SolutionMappingBase<I> implements SolutionMapping<I> {

    private String id;
    private long creation_timestamp, cep_timestamp;
    private I element;

    @Override
    public I get() {
        return element;
    }

    @Override
    public long getCreationTime() {
        return creation_timestamp;
    }



}

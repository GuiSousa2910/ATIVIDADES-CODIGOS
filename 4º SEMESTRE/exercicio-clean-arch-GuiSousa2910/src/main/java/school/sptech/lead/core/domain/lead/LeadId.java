package school.sptech.lead.core.domain.lead;

import java.util.UUID;

public class LeadId {
    private UUID value;

    public LeadId(UUID value) {
        this.value = value;
    }

    public static LeadId novo() {
        return new LeadId(UUID.randomUUID());
    }

    public static LeadId existente(String id    ) {
        return new LeadId(UUID.fromString(id));
    }

    public UUID getValue() {
        return value;
    }

}

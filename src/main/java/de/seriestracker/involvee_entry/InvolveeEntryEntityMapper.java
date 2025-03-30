package de.seriestracker.involvee_entry;

public final class InvolveeEntryEntityMapper {
    public static InvolveeEntryDTO involveeEntryToInvolveeEntryDTO(final InvolveeEntry involveeEntry) {
        return new InvolveeEntryDTO(involveeEntry.getId(), involveeEntry.getPerson(), involveeEntry.getMovie(), involveeEntry.getRoleType(), involveeEntry.getRole());
    }
}

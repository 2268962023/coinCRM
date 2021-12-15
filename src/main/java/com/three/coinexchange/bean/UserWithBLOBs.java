package com.three.coinexchange.bean;

public class UserWithBLOBs extends User {
    private String inviteRelation;

    private String agentNote;

    public String getInviteRelation() {
        return inviteRelation;
    }

    public void setInviteRelation(String inviteRelation) {
        this.inviteRelation = inviteRelation == null ? null : inviteRelation.trim();
    }

    public String getAgentNote() {
        return agentNote;
    }

    public void setAgentNote(String agentNote) {
        this.agentNote = agentNote == null ? null : agentNote.trim();
    }
}
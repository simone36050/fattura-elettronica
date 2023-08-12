package it.noriepa.fatturapa.xml.header.cessionariocommittente;

import it.noriepa.fatturapa.jaxb.CessionarioCommittenteType;


import java.util.Optional;

public class CessionarioCommittente {

    private DatiAnagraficiCessionarioCommittente datiAnagrafici;
    private SedeCessionarioCommittente sede;
    private Optional<StabileOrganizzazione> stabileOrganizzazione;
    private Optional<RappresentanteFiscale> rappresentanteFiscale;

    public CessionarioCommittente(){}

    public CessionarioCommittente(DatiAnagraficiCessionarioCommittente datiAnagrafici, SedeCessionarioCommittente sede) {
        this.datiAnagrafici = datiAnagrafici;
        this.sede = sede;
    }

    public CessionarioCommittente(DatiAnagraficiCessionarioCommittente datiAnagrafici, SedeCessionarioCommittente sede, Optional<StabileOrganizzazione> stabileOrganizzazione, Optional<RappresentanteFiscale> rappresentanteFiscale) {
        this.datiAnagrafici = datiAnagrafici;
        this.sede = sede;
        this.stabileOrganizzazione = stabileOrganizzazione;
        this.rappresentanteFiscale = rappresentanteFiscale;
    }


    public DatiAnagraficiCessionarioCommittente getDatiAnagrafici() {
        return datiAnagrafici;
    }

    public void setDatiAnagrafici(DatiAnagraficiCessionarioCommittente datiAnagrafici) {
        this.datiAnagrafici = datiAnagrafici;
    }

    public SedeCessionarioCommittente getSede() {
        return sede;
    }

    public void setSede(SedeCessionarioCommittente sede) {
        this.sede = sede;
    }

    public Optional<StabileOrganizzazione> getStabileOrganizzazione() {
        return stabileOrganizzazione;
    }

    public void setStabileOrganizzazione(Optional<StabileOrganizzazione> stabileOrganizzazione) {
        this.stabileOrganizzazione = stabileOrganizzazione;
    }

    public Optional<RappresentanteFiscale> getRappresentanteFiscale() {
        return rappresentanteFiscale;
    }

    public void setRappresentanteFiscale(Optional<RappresentanteFiscale> rappresentanteFiscale) {
        this.rappresentanteFiscale = rappresentanteFiscale;
    }

    public CessionarioCommittenteType creaCessionarioCommittente(){
        CessionarioCommittenteType cessionarioCommittenteType = new CessionarioCommittenteType();
        cessionarioCommittenteType.setDatiAnagrafici(datiAnagrafici.creaDatiAnagraficiCessionario());
        cessionarioCommittenteType.setSede(sede.creaSede());
        if(Optional.ofNullable(stabileOrganizzazione).isPresent()) {
            cessionarioCommittenteType.setStabileOrganizzazione(stabileOrganizzazione.get().creaStabileOrganizzazione());
        }
        if(Optional.ofNullable(rappresentanteFiscale).isPresent()) {
            cessionarioCommittenteType.setRappresentanteFiscale(rappresentanteFiscale.get().creaRappresentanteFiscaleCessionario());
        }
        return cessionarioCommittenteType;
    }
}

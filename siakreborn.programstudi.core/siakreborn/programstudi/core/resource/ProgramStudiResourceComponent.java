package siakreborn.programstudi.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ProgramStudiResourceComponent implements ProgramStudiResource{
	protected RepositoryUtil<ProgramStudi> programstudiRepository;

    public ProgramStudiResourceComponent(){
        this.programstudiRepository = new RepositoryUtil<ProgramStudi>(siakreborn.programstudi.core.ProgramStudiComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveProgramStudi(VMJExchange vmjExchange);
    public abstract ProgramStudi createProgramStudi(VMJExchange vmjExchange);
	public abstract ProgramStudi createProgramStudi(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateProgramStudi(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getProgramStudi(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllProgramStudi(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> transformProgramStudiListToHashMap(List<ProgramStudi> ProgramStudiList);
    public abstract List<HashMap<String,Object>> deleteProgramStudi(VMJExchange vmjExchange);

}

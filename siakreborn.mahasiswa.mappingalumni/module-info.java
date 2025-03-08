module siakreborn.mahasiswa.mappingalumni {
	requires siakreborn.mahasiswa.core;
    exports siakreborn.mahasiswa.mappingalumni;

	requires vmj.routing.route;
	requires vmj.hibernate.integrator;
	requires prices.auth.vmj;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;

	opens siakreborn.mahasiswa.mappingalumni to org.hibernate.orm.core, gson;
}

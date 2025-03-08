module siakreborn.bobotkomponenpenilaian.core {
	requires siakreborn.komponenpenilaian.core;
	requires siakreborn.subcpmk.core;
	requires siakreborn.cpmk.core;
	exports siakreborn.bobotkomponenpenilaian;
    exports siakreborn.bobotkomponenpenilaian.core;
	requires vmj.routing.route;
	requires vmj.hibernate.integrator;
	requires prices.auth.vmj;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;

	opens siakreborn.bobotkomponenpenilaian.core to org.hibernate.orm.core, gson;
}

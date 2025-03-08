module siakreborn.informasi.akademik {
  requires siakreborn.util.core;
  requires siakreborn.informasi.core;
  requires siakreborn.adminakademik.core;

  exports siakreborn.informasi.akademik;

  requires vmj.routing.route;
  requires vmj.hibernate.integrator;
  requires vmj.auth;
  requires java.logging;
  // https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
  requires java.naming;

  opens siakreborn.informasi.akademik to org.hibernate.orm.core, gson;
}

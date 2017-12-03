INSERT INTO users (id, username, email, password, enabled, name)
VALUES (
  1,
  'Customer',
  'user@handioq.ru',
  '$2a$08$u4eRExB5CAPAGD3CX83Ld.n16SfecMsw5xJOK9Jy676PnPynpiifG',
  TRUE,
  'John namevoich'
);

INSERT INTO users (id, username, email, password, enabled, name)
VALUES (
  2,
  'Admin',
  'admin@handioq.ru',
  '$2a$08$u4eRExB5CAPAGD3CX83Ld.n16SfecMsw5xJOK9Jy676PnPynpiifG',
  TRUE,
  'Andrew Balalakhanov'
);

INSERT INTO users (id, username, email, password, enabled, name)
VALUES (
  3,
  'Courier',
  'user@diber.com',
  '$2a$08$u4eRExB5CAPAGD3CX83Ld.n16SfecMsw5xJOK9Jy676PnPynpiifG',
  TRUE,
  'Andrew Balalakhanov'
);

INSERT INTO roles (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 1);

INSERT INTO oauth_client_details
(client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information , autoapprove)
VALUES
  ('clientapp', 'todo-services', '123456', 'read', 'password', 'http://localhost:8080/cheapi', NULL, 7200, 0, NULL, 'false');

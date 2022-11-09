insert into clients (client_id, username, password, "first", "last") values ('clientNumberOneId', 'clientNumberOneUsername', 'password', 'Bobby', 'Tables');
insert into clients (client_id, username, password, "first", "last") values ('clientNumberTwoId', 'clientNumberTwoUsername', 'password', 'Susan', 'Tables');

insert into helpers (helper_id, username, password, "first", "last") values ('helperNumberOneId', 'helperNumberOneUsername', 'password', 'Tommy', 'Tables');
insert into helpers (helper_id, username, password, "first", "last") values ('helperNumberTwoId', 'helperNumberTwoUsername', 'password', 'Rhonda', 'Tables');

insert into requests (request_id, client_id, title, description, deadline, availability) values ('requestNumberOneId', 'clientNumberOneId', 'bobbysRequest', 'description', '2023-02-26', 'OPEN');
insert into requests (request_id, client_id, title, description, deadline, availability) values ('requestNumberTwoId', 'clientNumberTwoId', 'susansRequest', 'description', '2023-03-14', 'OPEN');
insert into requests (request_id, client_id, title, description, deadline, availability) values ('requestNumberThreeId', 'clientNumberOneId', 'bobbysRequest', 'description', '2023-02-26', 'OPEN');
insert into requests (request_id, client_id, title, description, deadline, availability) values ('requestNumberFourId', 'clientNumberTwoId', 'susansRequest', 'description', '2023-03-14', 'OPEN');

insert into bids (bid_id, helper_id, request_id, amount, status) values ('bidNumberOneId', 'helperNumberOneId', 'requestNumberOneId', 25.78, 'PENDING');
insert into bids (bid_id, helper_id, request_id, amount, status) values ('bidNumberTwoId', 'helperNumberTwoId', 'requestNumberTwoId', 358.45, 'PENDING');
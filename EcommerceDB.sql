--
-- PostgreSQL database dump
--

-- Dumped from database version 17.1
-- Dumped by pg_dump version 17.1

-- Started on 2024-11-20 17:55:13

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 16442)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    id bigint NOT NULL,
    name character varying(255),
    email character varying(255),
    phone character varying(20) NOT NULL,
    password character varying(255)
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16461)
-- Name: inventory; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inventory (
    id bigint NOT NULL,
    quantity integer,
    date_last_inventory time(6) with time zone,
    name character varying(255),
    product_id bigint
);


ALTER TABLE public.inventory OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16456)
-- Name: order_detail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_detail (
    id bigint NOT NULL,
    quantity bigint,
    unit_price double precision,
    id_orders bigint NOT NULL,
    id_product bigint NOT NULL
);


ALTER TABLE public.order_detail OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16522)
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    id bigint NOT NULL,
    order_date timestamp(6) without time zone,
    total_price double precision,
    customer_id bigint,
    state character varying(255)
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16521)
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.orders ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 217 (class 1259 OID 16435)
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id bigint NOT NULL,
    name character varying(255),
    description character varying(500) NOT NULL,
    price double precision,
    img character varying(255) NOT NULL,
    category character varying(255) NOT NULL,
    state boolean
);


ALTER TABLE public.products OWNER TO postgres;

--
-- TOC entry 4874 (class 0 OID 16442)
-- Dependencies: 218
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (id, name, email, phone, password) FROM stdin;
123456789	Juan Pérez	juan.perez@example.com	1234567890	JP123456789
987654312	Ana Gómez	ana.gomez@example.com	9876543210	AG987654312
112233446	Carlos Martínez	carlos.martinez@example.com	1122334455	CM112233446
556677880	Laura Fernández	laura.fernandez@example.com	5566778899	LF556677880
998877666	Pedro López	pedro.lopez@example.com	9988776655	PL998877666
223344557	Marta Ruiz	marta.ruiz@example.com	2233445566	MR223344557
776655444	Luis Sánchez	luis.sanchez@example.com	7766554433	LS776655444
889977667	Lucía Díaz	lucia.diaz@example.com	8899776655	LD889977667
334455668	Miguel Pérez	miguel.perez@example.com	3344556677	MP334455668
223344778	Elena Torres	elena.torres@example.com	2233447777	ET223344778
667788991	Fernando Gómez	fernando.gomez@example.com	6677889900	FG667788991
445566779	Rosa Hernández	rosa.hernandez@example.com	4455667788	RH445566779
998866555	Jorge Fernández	jorge.fernandez@example.com	9988665544	JF998866555
554433222	Raquel López	raquel.lopez@example.com	5544332211	RL554433222
778899113	Antonio García	antonio.garcia@example.com	7788991122	AG778899113
332211446	Verónica Sánchez	veronica.sanchez@example.com	3322114455	VS332211446
110022335	Carlos Rodríguez	carlos.rodriguez@example.com	1100223344	CR110022335
998877224	Gabriela Martínez	gabriela.martinez@example.com	9988772233	GM998877224
112233670	Antonio Pérez	antonio.perez@example.com	1122336699	AP112233670
667788224	Patricia López	patricia.lopez@example.com	6677882233	PL667788224
445566778	Sandra Torres	sandra.torres@example.com	4455667788	ST445566779
556677225	Ricardo Díaz	ricardo.diaz@example.com	5566772244	RD556677225
334455780	Alicia García	alicia.garcia@example.com	3344557799	AG334455780
990011224	Juan Ruiz	juan.ruiz@example.com	9900112233	JR990011224
778899332	Paula Sánchez	paula.sanchez@example.com	7788993311	PS778899332
112233999	Felipe Martínez	felipe.martinez@example.com	1122339988	FM112233999
667788444	Marcela Gómez	marcela.gomez@example.com	6677884433	MG667788444
334455883	Antonio López	antonio.lopez@example.com	3344558822	AL334455883
556677890	María Rodríguez	maria.rodriguez@example.com	5566778899	MR556677890
667788999	José Sánchez	jose.sanchez@example.com	6677889988	JS667788999
998877444	Beatriz Díaz	beatriz.diaz@example.com	9988774433	BD998877444
223344556	Álvaro López	alvaro.lopez@example.com	2233445555	AL223344556
112233444	Esteban Gómez	esteban.gomez@example.com	1122334433	EG112233444
\.


--
-- TOC entry 4876 (class 0 OID 16461)
-- Dependencies: 220
-- Data for Name: inventory; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inventory (id, quantity, date_last_inventory, name, product_id) FROM stdin;
1	100	15:30:00-05	Bodega_NewYork	1
2	50	10:00:00-05	Bodega_Bogota	2
3	75	09:45:00-05	Bodega_Montevideo	3
4	150	16:00:00-05	Bodega_NewYork	6
5	200	14:00:00-05	Bodega_Bogota	25
6	120	08:30:00-05	Bodega_MexicoCity	45
7	180	13:15:00-05	Bodega_Cancun	2
8	140	12:00:00-05	Bodega_RioDeJaneiro	1
9	90	11:45:00-05	Bodega_Montevideo	10
10	110	10:30:00-05	Bodega_Santiago	3
\.


--
-- TOC entry 4875 (class 0 OID 16456)
-- Dependencies: 219
-- Data for Name: order_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.order_detail (id, quantity, unit_price, id_orders, id_product) FROM stdin;
1	2	15.99	1	5
2	1	25.5	1	12
3	3	12.75	2	7
4	4	18	2	5
5	1	19.5	3	21
6	2	14.99	3	30
7	1	11.75	4	5
8	2	29.99	4	19
9	1	9.99	5	8
10	5	15	5	12
11	2	12.75	6	14
12	3	14	6	8
13	4	13.5	7	25
14	2	22.99	7	21
15	1	19.99	8	7
\.


--
-- TOC entry 4878 (class 0 OID 16522)
-- Dependencies: 222
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orders (id, order_date, total_price, customer_id, state) FROM stdin;
1	2024-11-19 14:30:00	150.75	123456789	Pendiente
2	2024-11-20 09:00:00	220	987654312	Completada
3	2024-11-21 16:45:00	75.5	112233446	Cancelada
4	2024-11-22 13:30:00	180.25	667788991	Pendiente
5	2024-11-23 11:00:00	125	223344556	Completada
6	2024-11-24 17:00:00	98.6	334455668	Activada
7	2024-11-25 14:15:00	320	445566778	Completada
9	2024-11-27 15:30:00	250.1	112233446	Activada
10	2024-11-28 12:30:00	175	667788991	Cancelada
11	2024-11-29 16:00:00	145	223344556	Pendiente
12	2024-11-30 13:15:00	130.75	334455668	Completada
13	2024-12-01 09:00:00	105.25	445566778	Activada
14	2024-12-02 11:30:00	265	123456789	Pendiente
15	2024-12-03 18:00:00	180.5	987654312	Cancelada
8	2024-11-26 10:45:00	200	556677880	Activada
16	2024-12-19 14:00:00	190.5	987654312	Activadaa
\.


--
-- TOC entry 4873 (class 0 OID 16435)
-- Dependencies: 217
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.products (id, name, description, price, img, category, state) FROM stdin;
1	Base Líquida MAC Studio Fix	Base fluida de alta cobertura	889	https://www.maccosmetics.com.mx/media/studio_fix.jpg	Foundation	t
2	Labial Rouge Dior 999	Labial rojo de larga duración	970	https://www.dior.com/media/labial_rouge.jpg	Lipstick	f
3	Paleta de Sombras Naked Heat	Sombras cálidas altamente pigmentadas	1500	https://www.urbandecay.com/media/naked_heat.jpg	Eyeshadow	t
4	Corrector NARS Radiant Creamy	Corrector de cobertura natural	720	https://www.narscosmetics.com/media/corrector_nars.jpg	Concealer	f
5	Delineador de Ojos Kat Von D Tattoo Liner	Delineador líquido de precisión	450	https://www.kvdbeauty.com/media/tattoo_liner.jpg	Eyeliner	t
6	Rubor Benefit Cosmetics Dandelion	Rubor rosado de acabado natural	500	https://www.benefitcosmetics.com/media/rubor_dandelion.jpg	Blush	f
7	Iluminador Becca Shimmering Skin Perfector	Iluminador en polvo de alto brillo	950	https://www.beccacosmetics.com/media/iluminador_becca.jpg	Highlighter	t
8	Set de Brochas Real Techniques	Kit de brochas esenciales para maquillaje	800	https://www.realtechniques.com/media/set_brochas.jpg	Tools	f
9	Crema CC IT Cosmetics Your Skin But Better	CC cream con SPF 50	1200	https://www.itcosmetics.com/media/cc_cream.jpg	Foundation	t
10	Polvo Traslúcido Laura Mercier	Polvo fijador de maquillaje	1050	https://www.lauramercier.com/media/polvo_traslucido.jpg	Powder	f
11	Pestañina Maybelline Lash Sensational	Máscara de pestañas de volumen extremo	250	https://www.maybelline.com/media/lash_sensational.jpg	Mascara	t
12	Base en Barra Bobbi Brown Skin Foundation	Base cremosa en barra	1150	https://www.bobbibrown.com/media/base_barra.jpg	Foundation	f
13	Labial Líquido Huda Beauty Matte	Labial líquido de acabado mate	590	https://www.hudabeauty.com/media/labial_huda.jpg	Lipstick	t
14	Sombra Líquida Stila Glitter & Glow	Sombra líquida con brillo	750	https://www.stilacosmetics.com/media/sombra_liquida.jpg	Eyeshadow	f
15	Corrector Tarte Shape Tape	Corrector de cobertura completa	700	https://www.tartecosmetics.com/media/corrector_shape.jpg	Concealer	t
16	Bálsamo Labial EOS	Bálsamo hidratante con vitamina E	120	https://www.evolutionofsmooth.com/media/balsamo.jpg	Lipcare	f
17	Kit de Contorno Fenty Beauty	Paleta para contornear	1400	https://www.fentybeauty.com/media/kit_contorno.jpg	Contour	t
18	Sombra Individual ColourPop	Sombra monocromática de alta pigmentación	200	https://www.colourpop.com/media/sombra_individual.jpg	Eyeshadow	f
19	Esmalte Essie Gel Couture	Esmalte de uñas efecto gel	250	https://www.essie.com/media/esmalte.jpg	Nails	t
20	Spray Fijador Urban Decay All Nighter	Spray para fijar el maquillaje	800	https://www.urbandecay.com/media/spray_fijador.jpg	Setting Spray	f
21	Gel para Cejas Anastasia Beverly Hills	Gel transparente para peinar cejas	600	https://www.anastasiabeverlyhills.com/media/gel_cejas.jpg	Brows	t
22	Polvo Bronceador Too Faced Chocolate Soleil	Bronceador con aroma a chocolate	850	https://www.toofaced.com/media/bronceador.jpg	Bronzer	f
23	Eyeliner NYX Professional Makeup	Lápiz delineador resistente al agua	150	https://www.nyxcosmetics.com/media/eyeliner.jpg	Eyeliner	t
24	Labial MAC Ruby Woo	Labial mate clásico	750	https://www.maccosmetics.com/media/ruby_woo.jpg	Lipstick	f
25	Base Líquida L\\Oréal True Match	Base líquida adaptativa	280	https://www.loreal-paris.com/media/true_match.jpg	Foundation	t
26	Sombras Tarte Toasted	Paleta de sombras cálidas	1000	https://www.tartecosmetics.com/media/sombra_tarte.jpg	Eyeshadow	t
27	Polvo Fijador Maybelline Fit Me	Polvo traslúcido de acabado mate	350	https://www.maybelline.com/media/polvo_fijador.jpg	Powder	f
28	Delineador LOréal Superliner	Delineador líquido de alta precisión	180	https://www.loreal-paris.com/media/superliner.jpg	Eyeliner	t
29	Labial Maybelline SuperStay Matte Ink	Labial de larga duración	300	https://www.maybelline.com/media/superstay_lip.jpg	Lipstick	f
30	Base BareMinerals Original	Base mineral en polvo	950	https://www.bareminerals.com/media/base_original.jpg	Foundation	t
31	Esmalte OPI Nail Lacquer	Esmalte de uñas en color clásico	300	https://www.opi.com/media/nail_lacquer.jpg	Nails	f
32	Kit de Contorno NYX	Contorno y rubor en polvo	500	https://www.nyxcosmetics.com/media/contorno_nyx.jpg	Contour	t
33	Tónico Facial Pixi Glow Tonic	Tónico con ácido glicólico	650	https://www.pixibeauty.com/media/tonico_glow.jpg	Skincare	f
34	Máscara de Pestañas LOréal Voluminous	Máscara de volumen y definición	350	https://www.loreal-paris.com/media/voluminous_mascara.jpg	Mascara	t
35	Brocha de Contorno IT Cosmetics	Brocha para aplicar contorno	700	https://www.itcosmetics.com/media/brocha_contorno.jpg	Tools	f
36	Base Líquida Revlon ColorStay	Base para piel normal a seca	450	https://www.revlon.com/media/colorstay_base.jpg	Foundation	t
37	Labial Sephora Collection Cream Lip Stain	Labial cremoso de acabado mate	270	https://www.sephora.com/media/cream_lip_stain.jpg	Lipstick	f
38	Spray Fijador MAC Fix+	Spray fijador hidratante	650	https://www.maccosmetics.com/media/fix_plus.jpg	Setting Spray	t
39	Labial Pat McGrath Matte Trance	Labial de acabado mate y color intenso	1200	https://www.patmcgrath.com/media/matte_trance.jpg	Lipstick	f
40	Polvo Bronceador Physicians Formula	Bronceador en polvo de acabado natural	500	https://www.physiciansformula.com/media/bronzer.jpg	Bronzer	t
41	Paleta de Sombras Too Faced Natural Eyes	Paleta con tonos neutros para ojos	1050	https://www.toofaced.com/media/natural_eyes.jpg	Eyeshadow	t
42	Base M.A.C. Face and Body	Base ligera para un acabado natural y luminoso	1220	https://www.maccosmetics.com/media/face_and_body.jpg	Foundation	t
43	Paleta de Sombras Morphe 35O	Paleta con tonos cálidos y neutros	900	https://www.morphe.com/media/paleta_35o.jpg	Eyeshadow	f
44	Labial Fenty Beauty Stunna	Labial líquido de acabado mate	800	https://www.fentybeauty.com/media/stunna_lip.jpg	Lipstick	t
45	Corrector Maybelline Instant Age Rewind	Corrector con efecto anti-envejecimiento	290	https://www.maybelline.com/media/age_rewind.jpg	Concealer	f
46	Rubor NARS Orgasm	Rubor en polvo con un toque dorado	950	https://www.narscosmetics.com/media/rubor_orgasm.jpg	Blush	t
47	Máscara Tarte Lights, Camera, Lashes	Máscara de volumen y alargamiento	750	https://www.tartecosmetics.com/media/lights_camera_lashes.jpg	Mascara	f
48	Delineador Stila Stay All Day	Delineador líquido de larga duración	590	https://www.stilacosmetics.com/media/stay_all_day.jpg	Eyeliner	t
49	Set de Brochas Sigma Beauty	Set profesional de brochas para rostro y ojos	2200	https://www.sigmabeauty.com/media/set_brochas_sigma.jpg	Tools	f
51	Set de Brochas Morphe	Kit completo para maquillaje	2000	https://www.morphe.com/media/set_brochas.jpg	Tools	f
52	Set de Brochas Morphe	Set de Brochas Morphe	2000	https://co.pinterest.com/pin/291326669667304587		t
53	Set de Brochas Morpheo	Kit completo para maquillaje	2000	https://co.pinterest.com/pin/291326669667304587		t
\.


--
-- TOC entry 4884 (class 0 OID 0)
-- Dependencies: 221
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_id_seq', 1, false);


--
-- TOC entry 4714 (class 2606 OID 16448)
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);


--
-- TOC entry 4718 (class 2606 OID 16467)
-- Name: inventory inventory_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT inventory_pkey PRIMARY KEY (id);


--
-- TOC entry 4716 (class 2606 OID 16460)
-- Name: order_detail order_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT order_detail_pkey PRIMARY KEY (id);


--
-- TOC entry 4720 (class 2606 OID 16526)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 4712 (class 2606 OID 16441)
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- TOC entry 4727 (class 2606 OID 16558)
-- Name: orders fk624gtjin3po807j3vix093tlf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fk624gtjin3po807j3vix093tlf FOREIGN KEY (customer_id) REFERENCES public.customer(id);


--
-- TOC entry 4721 (class 2606 OID 16591)
-- Name: order_detail fke7jb3j9qxkmw9p02g8uxdwbff; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fke7jb3j9qxkmw9p02g8uxdwbff FOREIGN KEY (id_product) REFERENCES public.products(id);


--
-- TOC entry 4725 (class 2606 OID 16553)
-- Name: inventory fkq2yge7ebtfuvwufr6lwfwqy9l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT fkq2yge7ebtfuvwufr6lwfwqy9l FOREIGN KEY (product_id) REFERENCES public.products(id);


--
-- TOC entry 4722 (class 2606 OID 16586)
-- Name: order_detail fksoc8xhpecisgpugqfaasannc5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fksoc8xhpecisgpugqfaasannc5 FOREIGN KEY (id_orders) REFERENCES public.orders(id);


--
-- TOC entry 4723 (class 2606 OID 16581)
-- Name: order_detail id_orders; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT id_orders FOREIGN KEY (id) REFERENCES public.orders(id) NOT VALID;


--
-- TOC entry 4724 (class 2606 OID 16478)
-- Name: order_detail id_product; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT id_product FOREIGN KEY (id) REFERENCES public.products(id) NOT VALID;


--
-- TOC entry 4726 (class 2606 OID 16483)
-- Name: inventory id_product; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT id_product FOREIGN KEY (id) REFERENCES public.products(id) NOT VALID;


-- Completed on 2024-11-20 17:55:13

--
-- PostgreSQL database dump complete
--


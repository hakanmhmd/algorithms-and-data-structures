package AOC2017;

import java.util.*;

/**
 * Created by hakanmehmed on 07/12/2017.
 */
public class Day7 {
    public static class Graph {
        ArrayList<Node> nodes = new ArrayList<Node>();
        HashMap<String, Node> map = new HashMap<String, Node>();

        public Node getOrCreateNode(String name) {
            if (!map.containsKey(name)) {
                Node node = new Node(name);
                nodes.add(node);
                map.put(name, node);
            }

            return map.get(name);
        }

        public void addEdge(String s, String d) {
            Node start = getOrCreateNode(s);
            Node end = getOrCreateNode(d);
            start.addNeighbor(end);
        }

        public void addEdge(Node s, Node d){
            s.addNeighbor(d);
        }

        public ArrayList<Node> getNodes() {
            return nodes;
        }
    }

    public static class Node {
        ArrayList<Node> children = new ArrayList<Node>();
        HashMap<String, Node> map = new HashMap<String, Node>();
        String name;
        int weight;
        int dependencies = 0;

        public Node(String n) {
            name = n;
        }

        public int getWeight(){
            return weight;
        }
        public void setWeight(int w){
            this.weight = w;
        }

        public String getName() {
            return name;
        }

        public void addNeighbor(Node node) {
            if (!map.containsKey(node.getName())) {
                children.add(node);
                map.put(node.getName(), node);
                node.incrementDependencies();
            }
        }

        public void incrementDependencies() {
            dependencies++;
        }

        public ArrayList<Node> getChildren() {
            return children;
        }

        public void decrementDependencies() {
            dependencies--;
        }

        public int getNumberDependencies() {
            return dependencies;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        String input = "dihjv (2158) -> gausx, ncdmp, hozgrub\n" +
                "qhvca (428) -> odttvb, ymehff, ymyzbqc, jtdtmsi, wciuyuh\n" +
                "kuvqhnm (77)\n" +
                "eauol (56)\n" +
                "nwtkz (304) -> eykks, rxivjye\n" +
                "kmyvaog (440) -> jrvona, cdoyc, vgbwb, lbttqhl, qizznfs, bftdz, xqhvz\n" +
                "dcqofo (74)\n" +
                "qnhthgm (63)\n" +
                "fgkok (189) -> vjgjzbc, vjfllmr, drbqty\n" +
                "tvfwp (74)\n" +
                "jtwqgg (28)\n" +
                "igogak (57)\n" +
                "edaidjk (60)\n" +
                "jxhqld (75)\n" +
                "jbhxihl (79)\n" +
                "fbrdpr (28)\n" +
                "yjtudlp (60)\n" +
                "wgbdxsx (98)\n" +
                "ecpuvq (84)\n" +
                "emzlv (5)\n" +
                "isahru (26)\n" +
                "oamyk (69)\n" +
                "xxxcdbv (29)\n" +
                "rogwn (357)\n" +
                "jpovtel (31)\n" +
                "gkvko (24)\n" +
                "aqlfh (87)\n" +
                "cbvzgp (24) -> weotr, pgofcu, czswzal\n" +
                "vaqxfkm (43)\n" +
                "fwraw (64)\n" +
                "rqtlp (13) -> tmoib, pidha, yaqiuq, zprfu, ssjau, duhaz, qzaecfk\n" +
                "qisdg (15)\n" +
                "oryhdxc (12)\n" +
                "lywem (78)\n" +
                "ulrqrc (38)\n" +
                "sszuwps (86)\n" +
                "qanswmb (89)\n" +
                "keubv (101) -> yhfkwn, toqhzbx, rokeyia, vpspcd\n" +
                "lkpdlq (36)\n" +
                "ddvbfi (75)\n" +
                "nsfjyfr (79) -> pavvcsj, thidj, yvjkb, udkcxo, zehou\n" +
                "yorihlo (5983) -> eihhef, iayesbs, nduld, darnez\n" +
                "xfkhu (208) -> izjecb, edqurgi\n" +
                "onnmq (24)\n" +
                "zmbxthx (2453) -> tfjhcnn, uifjku, kgtcv\n" +
                "turomx (35)\n" +
                "pgofcu (82)\n" +
                "yveziks (55)\n" +
                "cbmcpho (20)\n" +
                "cosmq (70)\n" +
                "xvnqny (3179) -> dpmqmbp, pddgbo, mszglrh\n" +
                "juqsjg (47)\n" +
                "zfhup (56)\n" +
                "agvvr (45)\n" +
                "pkdqgo (84)\n" +
                "yupciox (47)\n" +
                "wplhnmi (689) -> qnmiv, esemf, qiftt\n" +
                "qujsvg (58)\n" +
                "bdnqwvw (10384) -> mqyvpvw, kfaib, rpgxh, kjudskk, gknpczm, mtukvee, xwbzev\n" +
                "lfjwzpr (80)\n" +
                "rpdiks (56)\n" +
                "kveyw (87)\n" +
                "eiwvcil (276) -> kmquncz, bsqltzs\n" +
                "lflpbjx (28)\n" +
                "nnoiyn (218) -> qthns, nhpvo\n" +
                "togvh (177) -> qcsal, totymbv, wdrdfsy\n" +
                "fmpkks (88) -> kbseli, tukvj, hygejev\n" +
                "hoocyf (77)\n" +
                "bbhffib (11) -> orrno, uaeuig, yjicxmr, yhmqg\n" +
                "bjaferd (58)\n" +
                "pjsevmq (112) -> sxnfkj, jyaztbk\n" +
                "zsksm (26) -> nghpciz, pboxau, nykhzm, edteba, bbhffib\n" +
                "mngpa (189) -> wevea, cjkpmpb\n" +
                "clqlpi (96) -> jgvmp, ikfnuu, dqfeapy\n" +
                "uppsb (10)\n" +
                "thafg (61)\n" +
                "dgmbzo (157) -> sjitmwi, krmoek\n" +
                "xtcoefd (13)\n" +
                "vnlbdhq (75)\n" +
                "rfowcu (46)\n" +
                "znpcapb (13)\n" +
                "gnrgy (839) -> zuqew, prnpyu, payeaey, mxiqn, qmkod, rgovzj\n" +
                "glmvo (1473) -> slilxt, fikmr\n" +
                "kiwzzsi (26)\n" +
                "lqrleq (114) -> xljwrd, lrymzqx, kszzcjg, ajxjsi\n" +
                "xdvxnd (82) -> alxuwj, ynfamq, oymcuyi, iesan, urqvtwz\n" +
                "oyort (96)\n" +
                "nmzkhig (11) -> jponcak, vyyvfme, amzzkz\n" +
                "cwgspa (10)\n" +
                "fahjx (47)\n" +
                "hckss (31)\n" +
                "eflhrzc (210) -> jnswdp, hrhky\n" +
                "gzgmcg (53)\n" +
                "ctvqg (32)\n" +
                "hmaslr (146) -> bvyiw, qeeyslp\n" +
                "xsxpz (46)\n" +
                "ztdib (46)\n" +
                "xhsokp (60)\n" +
                "gtadjbm (86)\n" +
                "qrrzkla (54)\n" +
                "zsmex (16)\n" +
                "wmiuyq (55)\n" +
                "mqovh (297)\n" +
                "tfejm (26)\n" +
                "hozgrub (96)\n" +
                "plgyftr (130) -> daomuol, lynvr\n" +
                "fjbxbui (57)\n" +
                "rnxpn (84)\n" +
                "jrrcr (22)\n" +
                "dxujggm (73)\n" +
                "gnows (81)\n" +
                "ilziw (54)\n" +
                "drbqty (15)\n" +
                "bgfjxde (292) -> cwgspa, uppsb\n" +
                "omcvezl (74)\n" +
                "cejrzz (88)\n" +
                "zbrant (83)\n" +
                "rxnyoaf (59)\n" +
                "vbobjo (98)\n" +
                "ofydl (110) -> ssmijv, uxytt\n" +
                "uwweklj (20)\n" +
                "iodjrt (60)\n" +
                "wdaxi (67) -> jxhqld, xxtds, udeyv\n" +
                "jivcmug (241)\n" +
                "rgovzj (147) -> cdmqq, iwvgsqj\n" +
                "gsspm (506) -> wakslhh, wjjov, fwjvl\n" +
                "cssxuh (85)\n" +
                "bdbhdz (22)\n" +
                "kjsimg (45)\n" +
                "mfaiso (99)\n" +
                "pzgihig (152) -> lggutbs, qrrzkla\n" +
                "xzrts (87)\n" +
                "alxuwj (241) -> sguelmy, wwibd\n" +
                "socdh (28)\n" +
                "tnezwo (65)\n" +
                "tonetb (74)\n" +
                "budlgt (226) -> edmdyyf, oulbft\n" +
                "wgkylta (318) -> tozgnf, nybvxpl\n" +
                "sddte (99) -> ywgsoss, pjgpn, unzqb\n" +
                "ijlnjse (45)\n" +
                "knkect (83)\n" +
                "nftvm (40) -> hepgwl, xsnvuhk, awuntf\n" +
                "nhpvo (56)\n" +
                "khfehu (76)\n" +
                "slnoou (74)\n" +
                "qkmsfo (220)\n" +
                "wciuyuh (184) -> waand, zutluof\n" +
                "prnpyu (29) -> pkdqgo, gprqd\n" +
                "illog (99)\n" +
                "pxijfx (35)\n" +
                "alcjel (83)\n" +
                "owjae (264) -> jxawhq, mgxmj\n" +
                "xsjmrv (178) -> husfjac, zsmex\n" +
                "kgjnta (24)\n" +
                "bfmatc (6)\n" +
                "whnmg (1178) -> fajwz, fjbxbui\n" +
                "ulsjdhh (44)\n" +
                "todve (10)\n" +
                "mgomqm (35)\n" +
                "okvspp (63)\n" +
                "kgtcv (41) -> mhbvu, wycrhq\n" +
                "vzyknp (26)\n" +
                "agmrdd (49)\n" +
                "ilqgy (57)\n" +
                "lhomu (99)\n" +
                "ixknb (57)\n" +
                "gffatn (656) -> rogwn, ralyx, xhnem\n" +
                "rbgidcj (1416) -> bgczgya, xgbxcgw, shzcz, qonlajs, naxbp\n" +
                "ikamn (24)\n" +
                "qzaecfk (253) -> ctvqg, yunmx\n" +
                "gknpczm (155) -> eiukshg, bomwsw, zsuhred\n" +
                "kulazu (78)\n" +
                "jgvmp (78)\n" +
                "wxhex (24)\n" +
                "tvdihgf (85)\n" +
                "xwbzev (254)\n" +
                "ankqb (83)\n" +
                "zehou (270)\n" +
                "yehoudc (237) -> tdvdbhx, rlzldzq, cchwxl\n" +
                "gvktxip (74)\n" +
                "kwbbdg (9)\n" +
                "fnuem (788) -> sgxaa, wkqbmut, wkqtgn\n" +
                "xljwrd (20)\n" +
                "xsnvuhk (90) -> ibjay, tonetb, uowuztv, hdvwu\n" +
                "pidha (77) -> iodjrt, wltkgyg, nipcsis, yjtudlp\n" +
                "gausx (96)\n" +
                "cbtfaaq (140) -> ochqzjy, oogoc\n" +
                "onurc (93)\n" +
                "oahfm (823) -> gxzkef, zujfczp, tmakc\n" +
                "jujcekp (87)\n" +
                "ochqzjy (32)\n" +
                "wvihi (36) -> rhdngzm, udeckgc, aooskui\n" +
                "eosnpun (42)\n" +
                "vnivx (24)\n" +
                "iziyeah (53)\n" +
                "wrrjvv (138) -> kktnr, nduasyx\n" +
                "rncwlve (45)\n" +
                "ohvsnc (16)\n" +
                "kuwksy (81)\n" +
                "epmklw (24)\n" +
                "bnhmicm (49)\n" +
                "kamhkoi (154) -> bndye, wjxgvh\n" +
                "sqvgekz (156) -> ogelzn, smueqkc\n" +
                "fikmr (87)\n" +
                "nipcsis (60)\n" +
                "fevoc (49)\n" +
                "itihxls (53)\n" +
                "hygejev (63)\n" +
                "xuwzr (289)\n" +
                "zzbpjiq (80)\n" +
                "aakqco (77)\n" +
                "mhtrp (80)\n" +
                "ftwjsi (5)\n" +
                "slilxt (87)\n" +
                "bgqxrj (98)\n" +
                "gpaljor (160) -> kuzskeg, qloih\n" +
                "vmrfkpj (97)\n" +
                "extedk (63)\n" +
                "wlswfp (38)\n" +
                "fphae (82) -> yhjmn, ylkotm, zmfcp\n" +
                "jlxseu (12)\n" +
                "waaszgs (95)\n" +
                "cdoyc (208) -> ikamn, ywfwlug\n" +
                "xqlcwdq (82)\n" +
                "iqsxq (61)\n" +
                "iegfxt (84)\n" +
                "lnbkylg (58)\n" +
                "qcsal (55)\n" +
                "onyvo (98)\n" +
                "hrfldlv (61)\n" +
                "pqccx (49)\n" +
                "zkpvqfo (24)\n" +
                "svpplpy (364) -> znpcapb, ervfo\n" +
                "ksbkavj (145) -> cypwd, rxnlgc\n" +
                "ucuojn (95)\n" +
                "fmszt (23)\n" +
                "sqoqld (5)\n" +
                "ymtwg (89) -> oqhdqg, qwfzkh, qrbhvs, phkvd, ytkgrpj, ylfkshq, drwjl\n" +
                "nxwsaq (59)\n" +
                "skcbz (98)\n" +
                "ygnrm (40)\n" +
                "asfjop (15)\n" +
                "doqmfx (152) -> ahsdq, gnows\n" +
                "jfrda (3994) -> lnpuarm, oahfm, nsfjyfr\n" +
                "kssoys (63)\n" +
                "syqthpz (70) -> zyfrk, nhlvwm, lfjwzpr, zzbpjiq\n" +
                "pxbyvn (98)\n" +
                "goulcd (164) -> wdngppj, vmrfkpj\n" +
                "keeet (281) -> wdpyn, hqyej\n" +
                "pscda (342)\n" +
                "edqurgi (91)\n" +
                "phkvd (37) -> vmbhr, zppzac, euaulyx, cabffwx\n" +
                "cpvefk (15)\n" +
                "jyyeena (51)\n" +
                "naxbp (17) -> ofgvb, ytvmvhy\n" +
                "cabffwx (71)\n" +
                "pvnch (61)\n" +
                "omvoojd (20)\n" +
                "edteba (305) -> qjdbq, yupciox\n" +
                "gkmrz (29)\n" +
                "qwfzkh (321)\n" +
                "eatpn (88)\n" +
                "ptfev (215) -> iemffhw, snzqh\n" +
                "kuzskeg (30)\n" +
                "acvbzia (390)\n" +
                "zbuqlk (52)\n" +
                "icbztci (67)\n" +
                "awebzjn (46)\n" +
                "hxwrnx (7)\n" +
                "yvjkb (9) -> pttqho, jujcekp, sabsqv\n" +
                "qdrqm (182) -> cssxuh, lpfrtfw\n" +
                "pynygd (99)\n" +
                "tthcan (67)\n" +
                "vzlomr (127) -> rztel, fscztrk\n" +
                "hljxim (70)\n" +
                "wputsbp (91) -> zdrfc, iqsxq\n" +
                "qsqxc (69)\n" +
                "jzztae (158) -> wqrxb, yjqyh\n" +
                "qloih (30)\n" +
                "nsmsgmk (93)\n" +
                "awuntf (276) -> kunyye, yveziks\n" +
                "ibjay (74)\n" +
                "ssszfaj (24)\n" +
                "wildi (97)\n" +
                "kunyye (55)\n" +
                "hvporje (17) -> xfuimef, pscda, pklufv, vejgx, togvh\n" +
                "ekcfvm (58)\n" +
                "wkqtgn (96) -> brqztvl, rbjzgxt, jciigs\n" +
                "dqfeapy (78)\n" +
                "gsjkku (24)\n" +
                "uxytt (92)\n" +
                "qnrlrm (57)\n" +
                "gvtcjha (98)\n" +
                "kygnpb (75)\n" +
                "yjqyh (78)\n" +
                "pixawh (64)\n" +
                "xwwdp (53)\n" +
                "yjijem (124) -> jyyeena, frpagb\n" +
                "uihqn (52)\n" +
                "hdvwu (74)\n" +
                "sijptix (87) -> ojatorf, wxlxyq, lkfttr, xfesea, ytatg, keeet, ghycpf\n" +
                "nzylp (26)\n" +
                "zcoqx (164) -> xxykvzq, slnoou\n" +
                "vlrgx (88) -> bmntp, eatpn, yvoyt\n" +
                "hqwqd (97)\n" +
                "ybsouxh (24)\n" +
                "wurmarr (46)\n" +
                "bmejz (97)\n" +
                "rfmtzl (9)\n" +
                "lclhy (36)\n" +
                "qyharq (92)\n" +
                "ixtmdxo (24)\n" +
                "nlrtoa (57)\n" +
                "bnqinhv (440) -> hgwpks, wputsbp, mngpa, dasoy\n" +
                "gndaa (12)\n" +
                "syzkg (1697) -> qzdatks, buekex\n" +
                "wevea (12)\n" +
                "bcefufj (22)\n" +
                "larhlj (152) -> tidour, qfxuh\n" +
                "npvrbd (896) -> fmpkks, vpmnutl, uvsgv\n" +
                "pjgpn (65)\n" +
                "mzjypeq (90) -> ihhmv, jckrdlz, kylpt\n" +
                "lfkfd (97)\n" +
                "wysgri (142) -> gnutx, vbqxz\n" +
                "zqhans (87)\n" +
                "lqsdtq (43)\n" +
                "zutluof (6)\n" +
                "wqxbp (34139) -> bdnqwvw, bdlqru, ysgrizu\n" +
                "mrdoeb (87)\n" +
                "xuprtp (93)\n" +
                "vgbwb (130) -> wesqml, ssinas\n" +
                "zoibb (46) -> ctosb, pskrkrn\n" +
                "qmoxv (42)\n" +
                "bdfns (29)\n" +
                "qqokzne (954) -> jscxo, fhcrsce, jscvn, amheqov, wvihi, wsxkjcu\n" +
                "mxiqn (107) -> kjsimg, agvvr\n" +
                "klyfish (1069) -> xxeoneh, kibotum, hmaslr, zuywf\n" +
                "lzjvenf (21) -> tjfib, jgjgxgb, ibyqrv\n" +
                "yeomv (42)\n" +
                "qdyjn (78)\n" +
                "kdvzyz (6)\n" +
                "ncdmp (96)\n" +
                "hdkeesr (56)\n" +
                "dcbquim (48)\n" +
                "ksjmqsc (529) -> oakpkr, ndsbbnm, fphae, extnd\n" +
                "sczsl (64)\n" +
                "akvfgdi (57)\n" +
                "njldiph (83)\n" +
                "dasoy (155) -> qppyecj, gkmrz\n" +
                "jlhdq (52)\n" +
                "ltwrzdl (16)\n" +
                "fenxwbi (42)\n" +
                "vhnpij (78)\n" +
                "frpagb (51)\n" +
                "hqxulc (5)\n" +
                "tretx (11)\n" +
                "jorvuw (83)\n" +
                "vwyrjd (31)\n" +
                "zpanms (59)\n" +
                "qjdbq (47)\n" +
                "qagqi (83) -> xqlcwdq, ezbdihm\n" +
                "nydgtu (73)\n" +
                "bndye (39)\n" +
                "wlnpbx (83)\n" +
                "vbqxz (85)\n" +
                "levsigy (43)\n" +
                "cdmqq (25)\n" +
                "ekrwiea (91)\n" +
                "rxnlgc (14)\n" +
                "mtflqcm (68)\n" +
                "kylpt (72)\n" +
                "arwyg (238) -> ngsgolg, qephec\n" +
                "gprqd (84)\n" +
                "qawlwzi (45782) -> jfrda, jwebvqn, ujwqlf\n" +
                "qjqqkjo (300) -> vwyrjd, ocddu\n" +
                "azjdyr (89)\n" +
                "xjgoko (622) -> larhlj, lrvaz, memnafg\n" +
                "thidj (116) -> xzllgwq, vcfxh\n" +
                "sguelmy (36)\n" +
                "tjfib (59)\n" +
                "rdnxsro (84)\n" +
                "sdvzbk (262) -> atvztnt, zkpvqfo, gavzpv, rjmjlq\n" +
                "ssvcrjn (26)\n" +
                "rilzcsz (186) -> epmklw, sczuqy\n" +
                "hkosdxh (79)\n" +
                "iodtwit (30)\n" +
                "lvlux (92)\n" +
                "udkcxo (84) -> xuprtp, simsfkz\n" +
                "acatw (69) -> tlpzsi, hakss, naiivve, pphbkn\n" +
                "tflqwyl (51)\n" +
                "zjlckg (9455) -> jvjdgph, sijptix, zmbxthx\n" +
                "adqqjrz (81) -> ebjind, odhurs\n" +
                "yceabkj (46)\n" +
                "tomfuoi (6)\n" +
                "vejgx (272) -> lzvpll, pxijfx\n" +
                "qmpazxn (37)\n" +
                "pskrkrn (90)\n" +
                "eigivg (43)\n" +
                "cvioak (68) -> qnhthgm, wboesxc\n" +
                "dwfxj (76)\n" +
                "kjudskk (206) -> vostn, ixtmdxo\n" +
                "xltuf (66)\n" +
                "rnjyw (55)\n" +
                "uowuztv (74)\n" +
                "zkmhy (220) -> rnjyw, tbswgx\n" +
                "cfxrv (83)\n" +
                "hrbse (124) -> lnwyra, xuzfgha\n" +
                "urqvtwz (81) -> qcayjn, lnbkylg, yfrcx, bjaferd\n" +
                "lzvpll (35)\n" +
                "dngizd (81)\n" +
                "sjitmwi (55)\n" +
                "tqruh (31)\n" +
                "tukvj (63)\n" +
                "mvncpt (21)\n" +
                "hzfarz (51)\n" +
                "ujqoks (20)\n" +
                "wezrgqw (210)\n" +
                "hopsivz (387) -> tufywu, zhmevu\n" +
                "cacfqur (9)\n" +
                "udeckgc (59)\n" +
                "lkimdg (10)\n" +
                "nulkw (61)\n" +
                "porcbbb (227) -> midrlp, cacfqur\n" +
                "lmjpuv (296) -> kxaxt, fahjx\n" +
                "wimpns (22)\n" +
                "oymcuyi (280) -> tretx, njarebf, svezft\n" +
                "qfxuh (20)\n" +
                "fxjkoqn (202) -> fwraw, pixawh\n" +
                "vcfxh (77)\n" +
                "jtdtmsi (90) -> gzgmcg, nrkdwvs\n" +
                "vkuusw (92)\n" +
                "apjkf (22)\n" +
                "ovdogi (165) -> shepkcs, npxgl, wxyrdp\n" +
                "ewbuve (88)\n" +
                "dqxfl (90)\n" +
                "xnmtop (83) -> ckugbl, yeomv, fyktlox\n" +
                "piewts (22)\n" +
                "gcvxpm (64) -> kveyw, kchjfpg, mrdoeb\n" +
                "tufywu (32)\n" +
                "xfesea (243) -> tthcan, wljomq\n" +
                "ysyfwqs (211)\n" +
                "ozdrm (76) -> lclhy, zggsrug, zvhtk, lkpdlq\n" +
                "oqhdqg (201) -> dunqe, fqhdf, ygnrm\n" +
                "gmmxg (29)\n" +
                "rokeyia (27)\n" +
                "gavzpv (24)\n" +
                "mifxlz (171) -> didfetj, rncwlve\n" +
                "cqjoftq (63)\n" +
                "fhcrsce (213)\n" +
                "ssjau (253) -> askmldt, kojat\n" +
                "wdsunq (58)\n" +
                "tcqkzp (208) -> udzokmu, lzlvrqk\n" +
                "eimcci (43)\n" +
                "xwxof (55)\n" +
                "spprj (68) -> jorvuw, cfxrv\n" +
                "ivkvrj (81)\n" +
                "xbabgu (155) -> lypml, zxvhoy\n" +
                "osnyi (50)\n" +
                "cdynw (89)\n" +
                "ldswpyl (30) -> jkjnsj, lpxekhm\n" +
                "rdbcued (24)\n" +
                "zunuwi (208) -> iziyeah, wdafwyi\n" +
                "pzjiiy (20)\n" +
                "xqhvz (192) -> liearc, ohvsnc, ltwrzdl, ypyuum\n" +
                "vtzay (74) -> vonbixj, qawlwzi, wqxbp, tcsrpxb, xlieqz, yghqsa, asexwc\n" +
                "ralyx (357)\n" +
                "rlpvqn (9)\n" +
                "yjngab (1573) -> yiigm, kntzn, rilzcsz, eqoick\n" +
                "vtnex (28)\n" +
                "ctosb (90)\n" +
                "zmicnlj (76)\n" +
                "hbcjzma (149) -> bbmvgyu, rxnyoaf\n" +
                "lmekort (6)\n" +
                "jkjnsj (87)\n" +
                "pyjymxj (59)\n" +
                "pjczjl (20)\n" +
                "wxmwf (29)\n" +
                "othvtfq (49)\n" +
                "atvztnt (24)\n" +
                "ehzatio (57)\n" +
                "ekdczsz (63)\n" +
                "njarebf (11)\n" +
                "qsjhc (59)\n" +
                "ridrtgx (9)\n" +
                "kamrqhv (57)\n" +
                "wgjbas (15)\n" +
                "ldtbli (78)\n" +
                "cniapi (15)\n" +
                "ulssbyo (62)\n" +
                "ashohg (12)\n" +
                "mtkliz (96) -> bxkicdp, pmlzll, ycqghs\n" +
                "extnd (178) -> piewts, rpiyqq, bdbhdz\n" +
                "wvdnc (77)\n" +
                "iyalpvz (13) -> uohcpp, xcyfp, ypbgol\n" +
                "smkeec (87)\n" +
                "ezbdihm (82)\n" +
                "amheqov (177) -> isnebf, rlpvqn, bllths, rfmtzl\n" +
                "bmqggm (108) -> hkamx, extedk\n" +
                "ajnnoo (99) -> ywpmdg, drsvx\n" +
                "wgwucvi (26)\n" +
                "xbwbjfa (46)\n" +
                "omlxdye (56) -> tdstj, gnktgh\n" +
                "esbswlu (246) -> kuvqhnm, aakqco\n" +
                "wljomq (67)\n" +
                "yowef (55) -> umhji, ucpgr, dpimy, nwxad\n" +
                "qzdatks (15)\n" +
                "ncuksjv (84) -> plcqel, mtflqcm\n" +
                "mrssfl (26)\n" +
                "uqjnlv (122) -> rqtgag, awebzjn, wurmarr, osbdc\n" +
                "xxykvzq (74)\n" +
                "ynfamq (187) -> fenxwbi, eosnpun, kybtr\n" +
                "jscxo (99) -> dathq, ixknb\n" +
                "ohpeic (695) -> cbvzgp, mjrxbh, aaibd\n" +
                "bnuozu (107) -> rstvy, kovebn, zwsjm\n" +
                "kxaxt (47)\n" +
                "rztel (62)\n" +
                "xubkl (102) -> bhzgqav, wftxaby\n" +
                "owsebz (26)\n" +
                "glqezpx (245) -> omvoojd, pzjiiy, oiuppwr\n" +
                "ssmijv (92)\n" +
                "mgdjgzf (573) -> fnsxlna, qjqqkjo, pgfhmr, tvtxqpd\n" +
                "rnzzm (246) -> uwweklj, ujqoks, cbmcpho\n" +
                "npxgl (13)\n" +
                "lzlvrqk (42)\n" +
                "xgbxcgw (97) -> ashohg, gndaa\n" +
                "ibffwi (21) -> zfxdqi, yxqmz, dvnvwgj, xnhlg\n" +
                "wzmrtpw (40)\n" +
                "lcggft (139) -> qzuyecq, sslulx\n" +
                "vlwmaxi (46)\n" +
                "fnsxlna (110) -> cqjoftq, kssoys, fwyreea, wkgzwhi\n" +
                "zlwnppb (491) -> uqjnlv, huidcr, rnzzm, mzjypeq, inycp\n" +
                "jyaztbk (61)\n" +
                "ipljy (79)\n" +
                "wdpyn (48)\n" +
                "pgfhmr (50) -> kulazu, lgmdhjw, qdyjn, lywem\n" +
                "vjgjzbc (15)\n" +
                "egtscru (9)\n" +
                "plcqel (68)\n" +
                "wbsul (175) -> ynqji, qcbubp\n" +
                "fajwz (57)\n" +
                "bftdz (24) -> fdpjo, ekcfvm, qujsvg, wdsunq\n" +
                "wkhsng (24)\n" +
                "nhrka (23)\n" +
                "njkscdv (10)\n" +
                "vihoep (161) -> qolkd, itihxls\n" +
                "wesqml (63)\n" +
                "xgsbu (19)\n" +
                "iayesbs (2129) -> zhzwir, zoibb, kyvysg\n" +
                "noutnp (202) -> kdvzyz, tomfuoi, bfmatc, lmekort\n" +
                "whnnb (66) -> yceabkj, vlwmaxi, xsxpz\n" +
                "ucpgr (38)\n" +
                "qzuyecq (34)\n" +
                "nwxad (38)\n" +
                "ljmkw (53) -> imdmnn, hkosdxh\n" +
                "vakhjoj (1289) -> reflh, himyfxm, hrbse\n" +
                "mwzhn (75)\n" +
                "otzqal (667) -> qagqi, vpdlxtj, fiilaqx\n" +
                "kktnr (30)\n" +
                "tmoib (303) -> hxwrnx, ukbfn\n" +
                "bkuqfi (8) -> gvtcjha, pxbyvn, miwvcdi, wgbdxsx\n" +
                "ifroqmy (4870) -> ksjmqsc, ohpeic, djomjuh\n" +
                "ghycpf (199) -> azjdyr, qanswmb\n" +
                "fecze (694) -> jzztae, doqmfx, givqy, zfrgif, budlgt, zunuwi\n" +
                "derxp (22)\n" +
                "siyudl (46)\n" +
                "eqcpltg (79)\n" +
                "sslulx (34)\n" +
                "ibvmb (49) -> njldiph, zerai, ankqb\n" +
                "lbnjp (122) -> ojcaeht, sszuwps\n" +
                "vwzfjcq (241)\n" +
                "ytatg (116) -> mldtcbl, jgsgm, aqlfh\n" +
                "tdvdbhx (19)\n" +
                "bomwsw (33)\n" +
                "aonteu (15)\n" +
                "ndsbbnm (76) -> mxdij, nmqoxw, eauol\n" +
                "rpgxh (140) -> eetdzon, igogak\n" +
                "ynqji (40)\n" +
                "obhlzp (56)\n" +
                "jscvn (169) -> twdnswr, bcefufj\n" +
                "empkyy (61)\n" +
                "peopfnu (17) -> etyhx, rpfhcus, yvyttr\n" +
                "wycrhq (25)\n" +
                "isnebf (9)\n" +
                "naiivve (43)\n" +
                "cchwxl (19)\n" +
                "swtbqxz (266)\n" +
                "hbcto (51)\n" +
                "husfjac (16)\n" +
                "uohcpp (63)\n" +
                "yozose (88)\n" +
                "ylfkshq (193) -> sczsl, ibdyuge\n" +
                "ergcql (46)\n" +
                "ebjind (65)\n" +
                "tohprmh (2242) -> tflqwyl, mdjhnv, tamautu, qxxkyr\n" +
                "bqbmy (49)\n" +
                "urbqmk (52)\n" +
                "zdrfc (61)\n" +
                "wwibd (36)\n" +
                "lawgz (35)\n" +
                "lkfttr (320) -> luzwzm, mqebpw, eodubb\n" +
                "ezxlkm (37)\n" +
                "eihhef (1752) -> adqqjrz, ysyfwqs, ljmkw, synynkd, imrqsxa\n" +
                "nduld (1449) -> lgkhn, cikijr, ijmrhsf, cvioak, lqrleq, ifncxs, bnuozu\n" +
                "cdsjzoz (1888) -> yowef, wdsari, lcggft\n" +
                "djxpma (93)\n" +
                "rstvy (29)\n" +
                "yvyttr (1210) -> qslmjtg, wrmovs, ibvmb, xmfrzwa\n" +
                "vnhsudk (60)\n" +
                "qrshe (43)\n" +
                "flovshu (15)\n" +
                "bwgjpdg (97)\n" +
                "bgczgya (107) -> cvgdzag, qdextxi\n" +
                "zfrgif (168) -> dxujggm, nydgtu\n" +
                "vpdlxtj (151) -> wxhex, gsjkku, wkhsng, ssszfaj\n" +
                "kwztfbl (88)\n" +
                "nduasyx (30)\n" +
                "jnswdp (60)\n" +
                "rbjzgxt (24)\n" +
                "cvgdzag (7)\n" +
                "cbxomli (91)\n" +
                "qmkod (57) -> hlauw, mgomqm, pmzvdb, lawgz\n" +
                "weotr (82)\n" +
                "ifncxs (54) -> fglgibd, hljxim\n" +
                "ogelzn (35)\n" +
                "pkdwpbh (15)\n" +
                "mdjhnv (31) -> njkscdv, hincte\n" +
                "hxxupnf (43) -> cjztdo, uvgvi\n" +
                "imrqsxa (115) -> drwlyvx, ybsouxh, xfmyvg, oibng\n" +
                "gnutx (85)\n" +
                "iloykn (81)\n" +
                "heudq (6)\n" +
                "lggutbs (54)\n" +
                "bllths (9)\n" +
                "edmdyyf (44)\n" +
                "wrmovs (132) -> alcjel, knkect\n" +
                "nfwzt (69)\n" +
                "esemf (99) -> iqeqpuv, seruan\n" +
                "omspdwl (245) -> ggmpihl, emzlv, kjyhry\n" +
                "uillw (1744) -> zfswb, wbsul, dumykdj\n" +
                "ijmrhsf (102) -> ztdib, rfowcu\n" +
                "xgllgu (62) -> illog, mfaiso\n" +
                "ofgvb (52)\n" +
                "fscztrk (62)\n" +
                "iwfjou (31)\n" +
                "egqaydx (814) -> ofydl, sddte, nqpyzt, yehoudc, szpoqm, lbnjp\n" +
                "vvemxld (63) -> xoavai, subauko\n" +
                "jkukq (9)\n" +
                "tmakc (44) -> tqxmke, ipljy\n" +
                "veefoj (99)\n" +
                "cmopifq (234) -> zpanms, nxwsaq\n" +
                "jkzwu (70) -> zhphopf, pcljlai, uillw, qamvl, cdsjzoz, yjngab, vqhriyt\n" +
                "xkrxt (81)\n" +
                "fgltnc (22)\n" +
                "wdrbtqg (8) -> wezrgqw, eubxp, wmmmcdw, eealm, xsjmrv\n" +
                "wspzdb (60)\n" +
                "wzcttac (85)\n" +
                "wqlzmvc (87)\n" +
                "ervfo (13)\n" +
                "bxkicdp (57)\n" +
                "seruan (12)\n" +
                "wqocyox (99)\n" +
                "wdafwyi (53)\n" +
                "drsvx (71)\n" +
                "yntroh (82) -> rvakt, hoocyf, fgrvof, ccjmduk\n" +
                "uaeuig (97)\n" +
                "wspnoa (291) -> hqvtn, iodtwit\n" +
                "bhzgqav (18)\n" +
                "ycpxqjz (55)\n" +
                "szpoqm (98) -> qqedfa, qeovb, agmrdd, othvtfq\n" +
                "zxvhoy (85)\n" +
                "waand (6)\n" +
                "brqztvl (24)\n" +
                "jatwhbu (93)\n" +
                "tbswgx (55)\n" +
                "nghpciz (205) -> lfkfd, hqwqd\n" +
                "oulbft (44)\n" +
                "pcljlai (949) -> fxmiw, gmawv, pzgihig, ipqct, xgllgu, omspdwl\n" +
                "ggmpihl (5)\n" +
                "qonlajs (73) -> smuzxf, trxfjv\n" +
                "twijj (54) -> qrmgjdu, avyif, veefoj\n" +
                "owiryv (54)\n" +
                "yhfkwn (27)\n" +
                "eprlek (42)\n" +
                "xlieqz (18992) -> byytwu, yorihlo, vrpupk\n" +
                "geznv (32) -> tvdihgf, fccyl\n" +
                "smueqkc (35)\n" +
                "wdngppj (97)\n" +
                "vzits (78)\n" +
                "bdavc (79)\n" +
                "luzwzm (19)\n" +
                "lrvaz (96) -> qflimon, dcbquim\n" +
                "bvyiw (46)\n" +
                "esvca (90)\n" +
                "nylrq (400)\n" +
                "tezto (34)\n" +
                "qqedfa (49)\n" +
                "nulkvu (29)\n" +
                "xuzfgha (60)\n" +
                "vsivyn (38)\n" +
                "qzhemjq (91) -> cejrzz, yozose\n" +
                "bmntp (88)\n" +
                "pwotv (26)\n" +
                "vonbixj (42470) -> orssb, ewqui, ifroqmy\n" +
                "eleeg (82)\n" +
                "ylpapdi (15)\n" +
                "dpmqmbp (292) -> cmopifq, vlrgx, qdrqm\n" +
                "ciiqis (295) -> cqxfbv, socdh\n" +
                "lnwyra (60)\n" +
                "vyyvfme (35) -> jqomxi, hwljl, onyvo, bvykqm\n" +
                "jxawhq (47)\n" +
                "kntzn (78) -> vhnpij, tqnucz\n" +
                "fvbopgf (302) -> bnhmicm, pqccx\n" +
                "mgxmj (47)\n" +
                "dodbb (53)\n" +
                "smlvcc (1242) -> lzjvenf, plgyftr, wrrjvv, dlrpc, nevkxz\n" +
                "amzzkz (323) -> kiwzzsi, wgwucvi, mdyce, pwotv\n" +
                "jzmezwj (40)\n" +
                "yjicxmr (97)\n" +
                "ssinas (63)\n" +
                "ojcaeht (86)\n" +
                "tfjhcnn (91)\n" +
                "udeyv (75)\n" +
                "rlxoojp (446) -> cbtfaaq, whnnb, srbtea\n" +
                "ymehff (28) -> iegfxt, rdnxsro\n" +
                "wxyrdp (13)\n" +
                "hbncq (91) -> hwvxsq, dqxfl, hhoxisa, fuorh\n" +
                "drlkvy (190) -> nixbq, fqcxo, itggp, egtscru\n" +
                "scmwcz (20)\n" +
                "lpxekhm (87)\n" +
                "nevkxz (138) -> flovshu, iivqj, clikxp, wgjbas\n" +
                "mqyvpvw (254)\n" +
                "tdstj (88)\n" +
                "lyfyg (1272) -> whzdf, qlgbx, pfzcu, swtbqxz\n" +
                "bdejd (93)\n" +
                "tamautu (15) -> jlxseu, oryhdxc, fbedmnf\n" +
                "wdrdfsy (55)\n" +
                "bvtwq (47)\n" +
                "kjyhry (5)\n" +
                "unzqb (65)\n" +
                "jofsg (64) -> mwzhn, oumcdij, vnlbdhq\n" +
                "ouadkun (43)\n" +
                "byytwu (89) -> tohprmh, timjt, ncapjgu, yblxjc, wmhkk, dihjv, yxjeaj\n" +
                "wsxkjcu (97) -> pdkxh, ahklb, bdfns, xxxcdbv\n" +
                "ywthj (79)\n" +
                "ehofuzh (26)\n" +
                "ywpmdg (71)\n" +
                "duhaz (93) -> rpdiks, zfhup, hdkeesr, zsrdtht\n" +
                "mzozh (77) -> hiiqxv, qnrlrm, ehzatio, nlrtoa\n" +
                "hzuprgn (665) -> xnmtop, keubv, yhkrp\n" +
                "ltwvide (890) -> ajnnoo, acatw, qeyzth, jivcmug, aqzbepp, vwzfjcq\n" +
                "hkamx (63)\n" +
                "nrkdwvs (53)\n" +
                "cjkpmpb (12)\n" +
                "ojnmrwc (213) -> xbwbjfa, ergcql\n" +
                "hrhky (60)\n" +
                "xoavai (55)\n" +
                "totymbv (55)\n" +
                "aqzbepp (49) -> peaud, oyort\n" +
                "zsuhred (33)\n" +
                "aooskui (59)\n" +
                "shepkcs (13)\n" +
                "qggwp (87)\n" +
                "tidour (20)\n" +
                "avyif (99)\n" +
                "pdkxh (29)\n" +
                "kybtr (42)\n" +
                "qizznfs (100) -> vykcb, ldtbli\n" +
                "ykxrxbb (19)\n" +
                "liearc (16)\n" +
                "atkpc (43)\n" +
                "oumcdij (75)\n" +
                "knfad (87)\n" +
                "hincte (10)\n" +
                "nfwof (32)\n" +
                "oxwbxc (10)\n" +
                "bgnuk (65)\n" +
                "iivqj (15)\n" +
                "rlzldzq (19)\n" +
                "qolkd (53)\n" +
                "yxhfz (38)\n" +
                "qeeyslp (46)\n" +
                "qrmgjdu (99)\n" +
                "vbtznz (6) -> vovinsx, vkzka, adkvr\n" +
                "etcbg (54) -> eigivg, atkpc, tyzcg, jlhnkk\n" +
                "adkvr (97)\n" +
                "miwvcdi (98)\n" +
                "jwiwydu (667) -> ihgiq, hxxupnf, hlgydhq\n" +
                "kmquncz (57)\n" +
                "vrpupk (9477) -> kktud, egqaydx, fecze\n" +
                "kekabeg (17)\n" +
                "bovla (327) -> arbcqfz, mvncpt, xhypb\n" +
                "omfahxa (99)\n" +
                "gvwkbp (300) -> wxmwf, qiwsut\n" +
                "twgdnl (74)\n" +
                "dumykdj (71) -> lvlux, rebxtnk\n" +
                "zvhtk (36)\n" +
                "pmlzll (57)\n" +
                "fccyl (85)\n" +
                "zfxdqi (76)\n" +
                "fdpjo (58)\n" +
                "lpfrtfw (85)\n" +
                "tcsrpxb (48956) -> peopfnu, rajmc, xvnqny\n" +
                "svezft (11)\n" +
                "vqcjj (22)\n" +
                "nqpyzt (294)\n" +
                "subvci (97)\n" +
                "askmldt (32)\n" +
                "qeyzth (143) -> vlgwzi, bqbmy\n" +
                "zxqrm (232) -> fevoc, kritjfi\n" +
                "umhji (38)\n" +
                "xifubdw (15)\n" +
                "snxbszd (20)\n" +
                "pfzcu (266)\n" +
                "zhphopf (52) -> wspnoa, kaxrm, vmobtbb, ciiqis, threc, ysvmncq, twijj\n" +
                "ysvmncq (173) -> cdynw, kzchhz\n" +
                "paofxz (140) -> hckss, jpovtel\n" +
                "qflimon (48)\n" +
                "vovinsx (97)\n" +
                "qchmzht (79)\n" +
                "wkgzwhi (63)\n" +
                "wxlxyq (272) -> turomx, zpekki, rfbnete\n" +
                "drwlyvx (24)\n" +
                "kfaib (206) -> rdbcued, kgjnta\n" +
                "baovbha (65)\n" +
                "odhurs (65)\n" +
                "rpiyqq (22)\n" +
                "twdnswr (22)\n" +
                "ypbgol (63)\n" +
                "xhpzhpq (292)\n" +
                "ywgsoss (65)\n" +
                "yrepvc (34)\n" +
                "ocddu (31)\n" +
                "zfswb (155) -> osnyi, ofrfo\n" +
                "sxnfkj (61)\n" +
                "tvtxqpd (322) -> lkimdg, yqmse, todve, oxwbxc\n" +
                "qephec (76)\n" +
                "swhlcvm (47)\n" +
                "ahklb (29)\n" +
                "ydibgyz (27)\n" +
                "himyfxm (37) -> qsqxc, retzg, nfwzt\n" +
                "lcfycgg (1529) -> lhomu, omfahxa\n" +
                "zqozw (59)\n" +
                "hwljl (98)\n" +
                "zvlftj (53)\n" +
                "inycp (78) -> dwfxj, rnyyal, ilcoe\n" +
                "lynvr (34)\n" +
                "hhjspt (241) -> jtwqgg, bdjgtz, bynxcni\n" +
                "gkvojlo (87)\n" +
                "xzllgwq (77)\n" +
                "pboxau (399)\n" +
                "oazcn (45)\n" +
                "buekex (15)\n" +
                "odttvb (162) -> kekabeg, momoy\n" +
                "rfedd (74)\n" +
                "ymyzbqc (144) -> vzyknp, mrssfl\n" +
                "ftfvpmy (193) -> klmcwy, xltuf\n" +
                "utqtp (87) -> zqhans, knfad\n" +
                "ktnynk (23)\n" +
                "jlhnkk (43)\n" +
                "jponcak (339) -> ytgxvzv, derxp, cukeme, vqcjj\n" +
                "subauko (55)\n" +
                "bgkst (257) -> pjczjl, scmwcz\n" +
                "uifjku (91)\n" +
                "ujwqlf (46) -> xdvxnd, sbjvkrb, glilvcd, glmvo, eiennk\n" +
                "vjfllmr (15)\n" +
                "nhlvwm (80)\n" +
                "dpslcf (82)\n" +
                "tqnucz (78)\n" +
                "yhmqg (97)\n" +
                "bqqwwcn (1031) -> kamhkoi, omlxdye, ismqdcu\n" +
                "ismqdcu (178) -> lfrwzbb, ydibgyz\n" +
                "rebxtnk (92)\n" +
                "lcpfw (296) -> vrjes, bvtwq\n" +
                "drwjl (265) -> vtnex, qxzjhg\n" +
                "nykhzm (11) -> bmejz, wildi, qoyub, epdfbvu\n" +
                "rvakt (77)\n" +
                "hakss (43)\n" +
                "noqrlh (60)\n" +
                "epdfbvu (97)\n" +
                "iqeqpuv (12)\n" +
                "ywfwlug (24)\n" +
                "weywe (57)\n" +
                "kchjfpg (87)\n" +
                "fbedmnf (12)\n" +
                "uvsgv (237) -> eyotuoe, slhfj\n" +
                "fqcxo (9)\n" +
                "vsfjq (56)\n" +
                "whumv (84)\n" +
                "sczuqy (24)\n" +
                "hqyej (48)\n" +
                "fglidf (9)\n" +
                "yfrcx (58)\n" +
                "ytvmvhy (52)\n" +
                "vykcb (78)\n" +
                "cukeme (22)\n" +
                "pqiqied (93)\n" +
                "cikijr (32) -> xkrxt, zspsh\n" +
                "mtukvee (59) -> baovbha, tnezwo, bgnuk\n" +
                "vlgwzi (49)\n" +
                "wdsari (41) -> wlnpbx, zbrant\n" +
                "shzcz (52) -> ztlsw, ktnynk, fmszt\n" +
                "kaxrm (261) -> oazcn, ijlnjse\n" +
                "eubxp (81) -> vaqxfkm, levsigy, lqsdtq\n" +
                "vmobtbb (237) -> kamrqhv, weywe\n" +
                "zzacgi (90)\n" +
                "oogoc (32)\n" +
                "dlrpc (40) -> jbhxihl, kdjcqk\n" +
                "eealm (88) -> nulkw, pvnch\n" +
                "jciigs (24)\n" +
                "fpezemw (67)\n" +
                "lgkhn (134) -> wzzjnrl, snxbszd, vexft\n" +
                "ldyrkdm (40)\n" +
                "zezecwh (53)\n" +
                "pavvcsj (218) -> ssvcrjn, nzylp\n" +
                "kwelmvo (46) -> siyudl, wxiks\n" +
                "mszglrh (472) -> tcqkzp, xhpzhpq, wdaxi\n" +
                "fmsgmoq (135) -> xgsbu, ykxrxbb\n" +
                "ahsdq (81)\n" +
                "lypml (85)\n" +
                "simsfkz (93)\n" +
                "bdjgtz (28)\n" +
                "aaibd (174) -> vnivx, fcjoefo, gkvko, onnmq\n" +
                "mgihcl (354) -> gwcwh, nhrka\n" +
                "udzokmu (42)\n" +
                "qactli (85)\n" +
                "eqoick (176) -> nulkvu, gmmxg\n" +
                "synynkd (167) -> jrrcr, apjkf\n" +
                "darnez (77) -> syqthpz, lmjpuv, lcpfw, bovla, wgkylta, xfkhu, acvbzia\n" +
                "vrjes (47)\n" +
                "zemwgsa (130) -> isahru, cltdxy, tfejm, obzcog\n" +
                "hlauw (35)\n" +
                "pttqho (87)\n" +
                "zhmevu (32)\n" +
                "mhbvu (25)\n" +
                "autys (32)\n" +
                "qeovb (49)\n" +
                "brhvbt (93)\n" +
                "jrkohk (98)\n" +
                "yiigm (122) -> qqwda, vsfjq\n" +
                "gdfxr (1002) -> jrkohk, bgqxrj\n" +
                "yqmse (10)\n" +
                "bdbzuf (539) -> ztpizq, gbyiobd, vzlomr\n" +
                "toqhzbx (27)\n" +
                "obzcog (26)\n" +
                "whzdf (140) -> vznyiu, eprlek, iovtj\n" +
                "yytai (13)\n" +
                "nwsjspa (18) -> noqrlh, edaidjk\n" +
                "djomjuh (20) -> bgkst, skrnzrc, mqovh, vbtznz, druym\n" +
                "pklufv (152) -> ucuojn, waaszgs\n" +
                "vmbhr (71)\n" +
                "jrvona (88) -> mowgm, whumv\n" +
                "hepgwl (226) -> ufjxj, mhtrp\n" +
                "oakpkr (132) -> obhlzp, qijjq\n" +
                "wopxs (74)\n" +
                "wltkgyg (60)\n" +
                "gnktgh (88)\n" +
                "yhjmn (54)\n" +
                "klmcwy (66)\n" +
                "bbmvgyu (59)\n" +
                "eifws (205) -> bfvol, qmoxv\n" +
                "xinyjeu (44)\n" +
                "bfvol (42)\n" +
                "mowgm (84)\n" +
                "orssb (41) -> lyfyg, ymtwg, ltwvide, zuccp\n" +
                "lnpuarm (918) -> ksbkavj, fmsgmoq, biumgl\n" +
                "bvykqm (98)\n" +
                "xnhlg (76)\n" +
                "mxwdp (81)\n" +
                "jowykql (63)\n" +
                "atnmou (54)\n" +
                "bdlqru (3118) -> gsspm, bdbzuf, whnmg, bnqinhv, hzuprgn, fnuem, nmzkhig\n" +
                "ddcgqm (10) -> smkeec, wqlzmvc, tcifkj, xzrts\n" +
                "gjkplw (85)\n" +
                "gsbypm (52) -> msnnza, drlkvy, etcbg, sqvgekz, noutnp, yjijem\n" +
                "jwebvqn (7762) -> iwudd, fvwwm, vvemxld\n" +
                "eiennk (912) -> porcbbb, bqdtmvh, txoqtpz\n" +
                "mqebpw (19)\n" +
                "ztpizq (65) -> qwwur, xdwcgk, ulssbyo\n" +
                "dunqe (40)\n" +
                "ccjmduk (77)\n" +
                "kzchhz (89)\n" +
                "wkqbmut (34) -> icbztci, fpezemw\n" +
                "txoqtpz (49) -> vbobjo, skcbz\n" +
                "vpmnutl (232) -> cniapi, xifubdw, asfjop\n" +
                "asexwc (93) -> tmclxe, aiuyg, jkzwu, zjlckg\n" +
                "yvoyt (88)\n" +
                "midrlp (9)\n" +
                "qlgbx (98) -> ecpuvq, rnxpn\n" +
                "bvczy (60)\n" +
                "qnmiv (79) -> gxvlomg, wimpns\n" +
                "qthns (56)\n" +
                "kibotum (68) -> gjkplw, wzcttac\n" +
                "nixbq (9)\n" +
                "ckugbl (42)\n" +
                "iveta (147) -> ywthj, oqahna\n" +
                "rnyyal (76)\n" +
                "vostn (24)\n" +
                "fcjoefo (24)\n" +
                "ibyqrv (59)\n" +
                "tcifkj (87)\n" +
                "jgjgxgb (59)\n" +
                "yduyn (40)\n" +
                "jnurmw (860) -> xuwzr, eifws, jofsg\n" +
                "wboesxc (63)\n" +
                "ibdyuge (64)\n" +
                "ypyuum (16)\n" +
                "yxjeaj (1226) -> mzozh, iveta, ojnmrwc, glqezpx\n" +
                "kyvysg (158) -> yrepvc, tezto\n" +
                "clikxp (15)\n" +
                "ojatorf (98) -> nsmsgmk, djxpma, onurc\n" +
                "eetdzon (57)\n" +
                "pqzsukm (40)\n" +
                "fgrvof (77)\n" +
                "iovtj (42)\n" +
                "zsrdtht (56)\n" +
                "wnvzf (37)\n" +
                "czswzal (82)\n" +
                "zmfcp (54)\n" +
                "hgwpks (213)\n" +
                "bqdtmvh (141) -> jlhdq, zbuqlk\n" +
                "qiftt (78) -> pkdwpbh, qisdg, cpvefk\n" +
                "vqhriyt (1903) -> paofxz, iyalpvz, geznv\n" +
                "udptfka (79) -> brhvbt, bdejd, pqiqied, jatwhbu\n" +
                "yxqmz (76)\n" +
                "zerai (83)\n" +
                "kmpjivb (175) -> hrfldlv, empkyy, thafg\n" +
                "kktud (72) -> sdvzbk, ddcgqm, goulcd, kmpjivb, awqjs, owjae, gvwkbp\n" +
                "lrymzqx (20)\n" +
                "fiilaqx (247)\n" +
                "aiuyg (12841) -> xjgoko, gdfxr, nftvm, jwiwydu\n" +
                "kojat (32)\n" +
                "wmmmcdw (36) -> gkvojlo, qggwp\n" +
                "gwcwh (23)\n" +
                "eykks (13)\n" +
                "qwwur (62)\n" +
                "hodlob (312)\n" +
                "iwudd (85) -> ulsjdhh, xinyjeu\n" +
                "wxiks (46)\n" +
                "zuccp (1166) -> zemwgsa, pjsevmq, bmqggm, spprj, fgkok\n" +
                "qppyecj (29)\n" +
                "uvgvi (67)\n" +
                "upmft (70)\n" +
                "ncmenyx (74)\n" +
                "vznyiu (42)\n" +
                "oiuppwr (20)\n" +
                "zujfczp (122) -> yduyn, ldyrkdm\n" +
                "sabsqv (87)\n" +
                "tmclxe (8705) -> rqtlp, kmyvaog, qqokzne, smlvcc\n" +
                "hqvtn (30)\n" +
                "qcayjn (58)\n" +
                "vexft (20)\n" +
                "ihgiq (39) -> oamyk, fhyimvw\n" +
                "qxxkyr (25) -> qmzef, xtcoefd\n" +
                "ycqghs (57)\n" +
                "rajmc (1933) -> rlxoojp, vtgfsqt, wdrbtqg, leytj, wplhnmi\n" +
                "iesan (151) -> owiryv, ilziw, atnmou\n" +
                "qslmjtg (283) -> hqxulc, ftwjsi, sqoqld\n" +
                "rxivjye (13)\n" +
                "qqwda (56)\n" +
                "hhoxisa (90)\n" +
                "yblxjc (2420) -> viqnxm, yytai\n" +
                "rhdngzm (59)\n" +
                "tlpzsi (43)\n" +
                "glilvcd (423) -> bzsupo, ptynfu, ldswpyl, pwaypt, ovdogi, vomul\n" +
                "ptynfu (110) -> swhlcvm, juqsjg\n" +
                "qrbhvs (285) -> ridrtgx, kwbbdg, fglidf, jkukq\n" +
                "hlgydhq (15) -> mxwdp, pwwtnz\n" +
                "ilcoe (76)\n" +
                "imdmnn (79)\n" +
                "gxvlomg (22)\n" +
                "djsyo (43)\n" +
                "bzsupo (32) -> gtadjbm, hmsbly\n" +
                "rjmjlq (24)\n" +
                "yhkrp (165) -> fgltnc, kfqykbd\n" +
                "kszzcjg (20)\n" +
                "gxzkef (116) -> qrshe, djsyo\n" +
                "jvjdgph (1373) -> hopsivz, hbncq, udptfka\n" +
                "wjxgvh (39)\n" +
                "ysgrizu (73) -> jnurmw, hvporje, syzkg, lcfycgg, bqqwwcn, gffatn, npvrbd\n" +
                "jqomxi (98)\n" +
                "vpspcd (27)\n" +
                "rpfhcus (452) -> svpplpy, arwyg, nlzfsx, yntroh, eiwvcil\n" +
                "eodubb (19)\n" +
                "givqy (18) -> tvfwp, rfedd, wopxs, omcvezl\n" +
                "kafnt (15)\n" +
                "ytgxvzv (22)\n" +
                "eyotuoe (20)\n" +
                "zyfrk (80)\n" +
                "bynxcni (28)\n" +
                "kfqykbd (22)\n" +
                "pphbkn (43)\n" +
                "biumgl (97) -> ulrqrc, wlswfp\n" +
                "viqnxm (13)\n" +
                "hwvxsq (90)\n" +
                "pwaypt (102) -> hzfarz, hbcto\n" +
                "lbttqhl (130) -> ekdczsz, jowykql\n" +
                "hmsbly (86)\n" +
                "ewqui (3753) -> gsbypm, enurd, otzqal, qhvca\n" +
                "krmoek (55)\n" +
                "mldtcbl (87)\n" +
                "sezloa (63)\n" +
                "zggsrug (36)\n" +
                "daomuol (34)\n" +
                "nlzfsx (240) -> kygnpb, ddvbfi\n" +
                "cltdxy (26)\n" +
                "oqahna (79)\n" +
                "orrno (97)\n" +
                "fhyimvw (69)\n" +
                "tqxmke (79)\n" +
                "mdyce (26)\n" +
                "zprfu (317)\n" +
                "ytkgrpj (265) -> lflpbjx, fbrdpr\n" +
                "iwvgsqj (25)\n" +
                "yghqsa (56478) -> vakhjoj, klyfish, rbgidcj, zsksm, mgdjgzf, gnrgy, zlwnppb\n" +
                "nedixbk (6)\n" +
                "kbseli (63)\n" +
                "zppzac (71)\n" +
                "sgxaa (64) -> urbqmk, uihqn\n" +
                "pddgbo (13) -> hbcjzma, vihoep, mtkliz, qzhemjq, dgmbzo\n" +
                "memnafg (15) -> zqozw, pyjymxj, qsjhc\n" +
                "mxdij (56)\n" +
                "qxzjhg (28)\n" +
                "xhnem (93) -> wrnejq, ewbuve, kwztfbl\n" +
                "oibng (24)\n" +
                "fxmiw (248) -> heudq, nedixbk\n" +
                "qamvl (949) -> wysgri, wfuwg, bgfjxde, zcoqx, hodlob\n" +
                "cuwpd (77)\n" +
                "itggp (9)\n" +
                "fvwwm (121) -> ehofuzh, owsebz\n" +
                "qijjq (56)\n" +
                "bsqltzs (57)\n" +
                "trxfjv (24)\n" +
                "zuqew (135) -> iwfjou, tqruh\n" +
                "wfuwg (57) -> yscbbtq, qactli, znxntbo\n" +
                "srbtea (204)\n" +
                "cqxfbv (28)\n" +
                "ufjxj (80)\n" +
                "wmhkk (2150) -> gvktxip, ncmenyx, dcqofo, twgdnl\n" +
                "ipqct (108) -> khfehu, zmicnlj\n" +
                "fwjvl (82) -> zzacgi, esvca\n" +
                "didfetj (45)\n" +
                "pmzvdb (35)\n" +
                "izjecb (91)\n" +
                "ztlsw (23)\n" +
                "lgmdhjw (78)\n" +
                "momoy (17)\n" +
                "payeaey (197)\n" +
                "etyhx (92) -> nwtkz, zkmhy, fxjkoqn, zxqrm, eflhrzc, clqlpi, nnoiyn\n" +
                "xcyfp (63)\n" +
                "xxtds (75)\n" +
                "gmawv (104) -> vzits, gvlbzp\n" +
                "qmzef (13)\n" +
                "skrnzrc (103) -> bwgjpdg, subvci\n" +
                "wrnejq (88)\n" +
                "ajxjsi (20)\n" +
                "tyzcg (43)\n" +
                "zuywf (118) -> pqzsukm, wzmrtpw, jzmezwj\n" +
                "huidcr (66) -> vnhsudk, wspzdb, bvczy, xhsokp\n" +
                "vtgfsqt (275) -> ptfev, mifxlz, utqtp\n" +
                "wftxaby (18)\n" +
                "snzqh (23)\n" +
                "ylkotm (54)\n" +
                "smuzxf (24)\n" +
                "wqrxb (78)\n" +
                "nmqoxw (56)\n" +
                "lfrwzbb (27)\n" +
                "hiiqxv (57)\n" +
                "wakslhh (156) -> xwwdp, dodbb\n" +
                "xdwcgk (62)\n" +
                "jgsgm (87)\n" +
                "fuorh (90)\n" +
                "reflh (180) -> nfwof, autys\n" +
                "mjrxbh (194) -> vsivyn, yxhfz\n" +
                "xfmyvg (24)\n" +
                "vomul (6) -> wqocyox, pynygd\n" +
                "qoyub (97)\n" +
                "tozgnf (36)\n" +
                "pwwtnz (81)\n" +
                "sbjvkrb (22) -> gcvxpm, ftfvpmy, xbabgu, ibffwi, hhjspt\n" +
                "druym (60) -> eqcpltg, qchmzht, bdavc\n" +
                "fyktlox (42)\n" +
                "kritjfi (49)\n" +
                "xmfrzwa (187) -> ezxlkm, wnvzf, qmpazxn\n" +
                "dvnvwgj (76)\n" +
                "euaulyx (71)\n" +
                "rqtgag (46)\n" +
                "threc (211) -> cosmq, upmft\n" +
                "dathq (57)\n" +
                "jckrdlz (72)\n" +
                "osbdc (46)\n" +
                "leytj (506) -> ngppbum, kwelmvo, nwsjspa, xubkl\n" +
                "fglgibd (70)\n" +
                "yscbbtq (85)\n" +
                "cjztdo (67)\n" +
                "slhfj (20)\n" +
                "enurd (528) -> gpaljor, ncuksjv, ozdrm, qkmsfo\n" +
                "yunmx (32)\n" +
                "awqjs (204) -> cuwpd, wvdnc\n" +
                "arbcqfz (21)\n" +
                "qdextxi (7)\n" +
                "rfbnete (35)\n" +
                "wzzjnrl (20)\n" +
                "xxeoneh (54) -> vkuusw, qyharq\n" +
                "kovebn (29)\n" +
                "kdjcqk (79)\n" +
                "zpekki (35)\n" +
                "zwsjm (29)\n" +
                "ofrfo (50)\n" +
                "fqhdf (40)\n" +
                "iemffhw (23)\n" +
                "timjt (2360) -> ouadkun, eimcci\n" +
                "nybvxpl (36)\n" +
                "ukbfn (7)\n" +
                "ngsgolg (76)\n" +
                "peaud (96)\n" +
                "ldyke (294) -> zezecwh, zvlftj\n" +
                "qcbubp (40)\n" +
                "gbyiobd (87) -> dpslcf, eleeg\n" +
                "wjjov (97) -> wmiuyq, xwxof, ycpxqjz\n" +
                "xhypb (21)\n" +
                "ncapjgu (46) -> esbswlu, bkuqfi, nylrq, fvbopgf, mgihcl, ldyke\n" +
                "ngppbum (12) -> okvspp, sezloa\n" +
                "dpimy (38)\n" +
                "fwyreea (63)\n" +
                "vkzka (97)\n" +
                "zhzwir (112) -> akvfgdi, ilqgy\n" +
                "znxntbo (85)\n" +
                "xfuimef (18) -> kuwksy, ivkvrj, dngizd, iloykn\n" +
                "msnnza (44) -> cbxomli, ekrwiea\n" +
                "retzg (69)\n" +
                "qiwsut (29)\n" +
                "eiukshg (33)\n" +
                "ikfnuu (78)\n" +
                "zspsh (81)\n" +
                "gvlbzp (78)\n" +
                "yaqiuq (272) -> aonteu, kafnt, ylpapdi\n" +
                "cypwd (14)\n" +
                "ihhmv (72)";

        String[] lines = input.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] elements = line.split("->");
            String nodeName = elements[0].split(" ")[0];
            String w = elements[0].split(" ")[1];
            Node n = g.getOrCreateNode(nodeName.trim());
            n.setWeight(Integer.parseInt(w.replace("(", "").replace(")", "")));
            String[] children = null;
            if(elements.length == 2) {
                children = elements[1].split(", ");
                for (int j = 0; j < children.length; j++) {
                    Node c = g.getOrCreateNode(children[j].trim());
                    g.addEdge(n, c);
                }

            }
        }

        Node root = null;
        ArrayList<Node> allNodes = g.getNodes();
        for(Node n: allNodes){
            if(n.getNumberDependencies() == 0){
                root = n;
            }
        }

        findImbalance(root);

    }

    private static int findImbalance(Node root) {
        if(root.getChildren().size() == 0){
            return root.getWeight();
        }

        ArrayList<Node> children = root.getChildren();
        ArrayList<Integer> weights = new ArrayList<>();
        ArrayList<Integer> directChildWeights = new ArrayList<>();
        for(Node c: children){
            directChildWeights.add(c.getWeight());
            weights.add(findImbalance(c));
        }

        // check if weights are balanced
        boolean allEquals = true;

        for (int i=1; i<weights.size(); i++) {
            if (!Objects.equals(weights.get(i - 1), weights.get(i))) {
                allEquals = false;
            }
        }

        if(allEquals){
            // add own weight
            int sum = weights.size() * weights.get(0);
            sum += root.getWeight();
            return sum;
        } else {
            // find the imbalance
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int w: weights){
                if(map.containsKey(w)){
                    map.put(w, map.get(w) + 1);
                } else {
                    map.put(w, 1);
                }
            }

            int outlier = -1;
            int others = -1;
            for(Map.Entry<Integer, Integer> en: map.entrySet()){
                int val = en.getValue();
                if(val == 1){
                    outlier = en.getKey();
                } else {
                    others = en.getKey();
                }
            }


            int outlierNodeW = directChildWeights.get(weights.indexOf(outlier));
            if(outlier > others){
                //reduce it
                System.out.println(outlierNodeW - (outlier-others));
            } else {
                System.out.println(outlierNodeW - (others-outlier));
            }

            return weights.size() * others;
        }
    }
}

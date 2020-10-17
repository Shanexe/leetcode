package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * <p
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -2^28 to 2^28 - 1 and the result is guaranteed to be at most 2^31 - 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * <p>
 * 要注意最优解，CD循环时候即可计算结果
 */
public class FourSum2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for (int i : A) {
            for (int j : B) {
                map.compute(i + j, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        for (int i : C) {
            for (int j : D) {
                if (map.get(-i - j) != null) {
                    ret += map.get(-i - j);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new FourSum2().fourSumCount(new int[]{-71978474, -28407390, 6487156, -5835667, -11819338, 10343068, 10768673, -245171709, 19738959, -46339242, 181229419, -176760610, -10337980, -207358751, -185412148, 102500358, 107833574, 250545333, -58873985, 106821619, 268124880, 55520158, 256155403, 200249464, 256954749, -41670481, -172102420, -161776521, 176941695, -53603760, -67111857, -27713855, -55333948, -215813542, -107067147, 98930659, 253393156, -196098380, -33056959, 174630496, -29395310, 105695498, -222391169, -139701651, -123000784, 38165534, -98009887, 82676096, -209663935, 91254707, 243440023, 96495216, -186156509, 192203188, 217929656, 222248651, 162150902, 95296092, 182504655, 964973, 223447285, 16336100, -202534131, 198076772, -218094374, 43698098, 176419657, -148324200, -143785502, -157834380, 265043122, 122589079, -184038991, -162395984, -246936037, -77713118, 241047628, 215897753, 112046993, -134358912, -195563478, 210843289, 205546356, 258601177, 214037482, -88343952, -252950129, 56615227, -206466635, 121363993, -234468310, 125536942, -76584060, 16648767, -81242925, -119529825, 70623988, -61229934, 129414837, -5096734, -40036154, 99473856, -81540983, 227618848, -63177608, -153233801, -254525992, -108570246, -218677661, 77101181, -10142928, -23455146, 100846160, -173243052, 195294601, 179435745, -106211022, -256863196, 185126002, 100063761, -211947235, 198846854, -224442102, 214832407, -235152963, -114218832, -225653215, 203844095, -28374131, -131535960, 207302351, 198551632, 12362543, -42252426, -5110144, -1789655, 203227705, 185485671, 104327543, 93708391, 101223013, -51029034, -207913967, -250224501, -228013159, -219084267, -192101482, -178470730, 84930559, -15283080, -166920501, 92936679, 80915963, -132773370, -133859950, -36263212, 267807924, 73630132, 15867083, -83446998, -87419351, -202169796, 249183800, -65641424, 221675154, -175181347, 149568254, 179970382, 8015104, -241178848, 49545775, 136594625, -93384496, -38634998, -208655366, -135319651, 50195804, 228747965, -83675970, -96147725, 50665760, -153907495, -200217502, 16274063, -79716485, 190120424, 108481017, -239673713, 231901658, -245547888, 188374954, -189583147, -161627305, 245629491, 84335290, 65342172, -138397675, 160380509, -139787131, -158188197, 153383613, -220425884, 265449800, 235879513, 227390973, -180258075, -157783358, 200421237, 5682905, 155361188, 139927984, -249721376, 81964010, 182928983, 73667135, 236833082, -7416994, 42913702, -84934068, 135699857, -171589203, -24517849, -153423339, 190200187, 35125846, 267263376, 7607854, -114818353, -143022046, 179542204, 55480768, 139176926, 4631172, 113365477, -159102158, -118792670, 86128035, 167355185, -188646772, -134765529, 217231322, 115685324, 117085598, 75612768, -189686865, -148646852, -122676312, -168795673, -188332159, -54052978, -204498215, -183024514, 233929464, -29242844, -30931217, 215016680, 208749496, -222588396, 173035066, -111620399, -251216657, 156383227, 120258522, 45251368, 184645641, 61014150, -18884643, 251838243, -216782609, 234246156, -114830713, 28272783, -70332034, 98318871, -41710077, 88812694, -7789083, 61765530, -36942919, 193942083, -119950274, -55040628, 101532610, -29739951, 105619704, 11194244, 262307985, 239168852, -29135197, -67190368, -107324830, 10327279, 183279704, 118119599, -204831134, 89274172, -13070967, 93154980, -140484935, 221452698, -177427697, 255348621, 12414766, 74289242, -143266337, 50477067, -263039481, 20530117, -178891218, -118880010, 11322215, 158847538, 176069352, 31547720, 164037790, -89074299, -197851703, -220012320, 131375916, 90414199, 36534830, 158741256, 98382412, -160839664, 4229156, 136064408, 33815093, 48992247, -35601728, -80793679, -166798858, -116719762, 217032017, -196304518, 48472, -190969983, 86320098, -135207520, 101506102, -951898, 94677427, 204431686, 111374413, 25984981, -173631664, 38809665, 147513898, 197698679, -60025105, 6839710, 209521930, 180150863, -95373339, 103651204, 235365610, 158822217, 48959157, -70488557, -222864214, 149263390, -17611706, -112935290, 55407761, -120478586, -20814580, -105294046, 245777863, 122519018, -75137248, 125259002, -4727500, -48612560, -40872923, -57918776, 137751972, 31668941, -53277529, -5992164, 12164456, 191655983, 109329293, 214082292, 69402972, -126962488, 88665691, -224411577, 106563677, -56350640, -224368618, -97218676, -5075836, 5479942, 97924441, -137524642, -236052868, -7425213, -258058308, -139479528, -54233917, 148657069, 226304313, 198846866, -51420353, -209286358, -244166187, -15174806, 158879379, 32219592, -70958555, -188643686, -21796585, -11255939, 211190902, -166480907, -71303129, -77842441, -252170083, -54623637, -152463366, 237990638, 142622889, -131257085, 34628835, -210654417, -251871806, 187775081, 185944120, 220538189, -175287939, 103168192, 56470314, -142901453, -172686551, -75780769, -15583119, 212971291, -19186971, -141006980, -109128195, -167889285, 55823372, 263092680, 127279051, 243913001, 21920020, 210028266, 239101125, 57884442, -72707532, -7185886, 75958947, 72074049, 49647288, -53465877, -4099345, 180748212, 16745602, -25658487, 234928676, -192758764, -226603250, 16426570, -109741689, 138282536, 180669336, -227834299, 81387163, -85728455, 266691672, 102161048, 32459504, -156181377, -196224757, 46743100, -173383827, 69940363, 157293941, 93796662, -131557188, 182464799, 207279738, -52250959, 170970028, -204517521, 153368453, 19096102, 154853650, -252096392, -9453068, 145651704, -121374777, 31516469, -245369030, -15984516, 112390793, 125003184, 127939456, 106765930, -198822613, -153099924},
                new int[]{-30451425, -70958332, 210992111, 205315439, -40697451, 249064743, 136919380, 141811620, 217809708, 84862193, 124181888, 190073003, 217255261, -146099934, -98347381, -188970320, -189520835, -196693669, -127181028, -37092694, 23240047, 165035085, -234215571, -68334211, -154429032, -97395972, -33804361, -133637989, 211888049, -30348379, 147378248, -35110616, -66967243, -63716249, 235688198, 194876519, 8766406, -101004212, -119560841, 161953247, 235889818, -69837369, 120219758, 54359594, -230930108, -94345364, -176514522, -177207433, -239072452, -175277854, -257945724, 42134263, 139262048, 192910401, -251072472, -93121657, 14338273, -135463675, 22787668, 202112183, 85360562, -233308782, -141664407, 123027502, -167152407, 237952051, -245273877, 200776728, 28170793, -7854067, 250290131, 56039764, 35303236, 3451395, -171190144, 126658080, 216820051, 195727076, 218034224, -54821190, -181431716, 67427047, 200230427, 184601460, 263219567, -197804478, 29571019, -178614705, -253928825, -32169910, 69544559, -130814412, -251036718, 53157593, 149486805, 9340434, -108565593, 1418302, 57992949, -111315079, -176909156, 104420276, 45614511, 59331062, 132365569, 232949255, 175578196, -115767402, 246317266, 71725944, 223166677, 50970983, -162127345, 121084648, 115236452, -257622251, 146066129, -15280743, -144450156, 79843044, -256194873, -124418950, 61773304, -49031784, -253396422, -188153248, 50462170, 47677294, -148742635, 183124152, -210159290, 73276704, 124806669, 180494883, 199918344, 255045227, -96500088, -31180300, -107195086, -49398457, 261665424, -193237237, -24904944, 235561863, 212219644, -102096038, 263189676, 218079117, 264914873, 52993357, -187302189, -219945042, -225212214, -191236848, 241668903, -202710145, 105387298, -210371115, -235813098, -76906406, -91699487, -10050149, 158820510, -43333539, 25338076, 11192914, 36701770, -67163999, -182841306, 249047762, 13571745, -102886503, 175667591, -10773602, 165132507, -79257461, 56544, 40631171, -217091370, 133876298, -151275187, 101049112, 28233468, 93705613, -135040534, -233525880, 209310642, -194008823, -266236147, 66000076, 52044668, -152794016, 254167487, -162250538, 191278397, 102915355, 110651913, 257060775, -75325508, 226370899, 169296998, 81292377, 2557680, 57415693, 120811175, -92167563, -69263413, -217921181, -215555766, 164576085, -224390071, 197131082, 181646324, 248077551, -244041961, -231521812, -125937358, -91931721, 250021613, -88867984, 46634085, -180213094, 192226644, 57629116, 5065104, 120608203, 197253481, -159497563, 146974152, 19544027, 19292064, 133328694, -148468341, 113802884, 186273091, -154393012, -203041589, -48038925, -125003749, 49115370, -256703681, -164229110, -197537865, -211431360, 167988568, -131687295, 158096089, -201591825, -26700045, -234274651, -70224787, 53182290, 75679069, 148310273, -241645636, -241250566, 365430, 63381941, -70658955, -21247397, -114924681, 115306674, -113340140, -13254917, -33707798, -146361368, -15873105, 55831951, 110534116, -134644064, -255146142, -206519430, 101723373, 146586720, -204084621, 227813322, 67977916, -66046128, -180855702, 255120451, -194480400, -233164602, 193669200, -246812697, 20116150, -1421651, -109827628, -224149912, 140676465, 122599270, -154274125, 41675729, 164587592, -32772115, 11020721, 246003484, 136208186, -120762214, -176174343, -154389843, 17824726, -55259089, -185523922, -50324009, 133355345, 70137398, -165607040, 19583668, 31327086, -126844213, -188561381, 252147803, -38619528, 114497569, -99196393, -12644807, 207539172, 248233133, 221445456, 22990223, 66186562, 212899743, -232437359, 106746400, -229228106, 131868633, 178240275, 148198410, 102974520, -32194377, -11295581, -211101505, -8317382, -21317664, -201220231, -129751454, -28852740, 70921956, 97587813, -264635837, 107165299, 28601534, 57314207, 257900815, 61080815, -10054077, 78384672, -170413569, 38894877, 246827167, -147575253, 202463359, 74429581, -146820842, -106734676, 136182356, -68033918, -112531275, 66306445, 117298766, -39829863, -24992654, 243343844, 209715486, -198146058, -172138761, -181717201, 209315469, -245633438, 116838408, -219094956, 49475010, -240872751, 97033580, 226123610, 255048115, 157533443, -102483971, 6434696, 32208271, -169591865, -59173976, -119688864, 57042718, 44909198, 187893548, 53853134, -233243389, 148381709, 154793157, 201666422, -248683684, 142947651, 185474272, 76318393, 224198501, -6973945, 158841981, -6681155, 7318011, -161135137, -12995329, -167416609, 266104273, 118717328, -32268271, 22037913, 123282950, 65960040, 53580139, 63571186, 41710206, -268425574, 54509459, -117809970, 53536329, -168306954, -5725650, 54225688, 91869843, -185888817, -95209429, -260979469, -262221754, 249407018, 144025279, -232720568, -13765995, 117553741, -145074483, -247635080, -264222388, -162640717, -239131606, -262100058, 110799953, -17794563, 168946223, -82146032, 40517936, -47440652, 38638915, 64223762, 167890580, 48329207, 252787568, -198528041, -5487646, -31395708, 225031422, 126427701, -166826170, -135199429, 212159976, -217062047, 33293856, 199564451, 37566001, 106753211, 66518914, 159050413, 11833256, 15246463, 197865196, 167954014, -245541241, -159678290, 25538325, 116468048, 144570090, 171328698, -137520520, 199346673, 23540399, -85340050, -223242047, 223727765, 225686457, 218723093, 231048021, -50284858, 237644762, -190776495, -135093982, 64484007, -48799159, -154532055, 136850661, -10280042, 148645472, -61103802, -68335508, 224037836, 4909000, -43173144, -112751199, 124662709, -117688301, -201806416, -654482},
                new int[]{221669372, -198001620, 15244180, -85651914, 187512073, 183505647, -240495316, 33170893, 131048656, -184341503, -110422027, -116580036, 83528072, -44275735, -245936274, -190744927, -174915154, 139891567, -211574228, 233659572, 131414598, 124377872, -245383956, -196554724, 212256846, 157139407, -232406115, -50504444, 84387077, 256372616, -204508328, 235560486, 163405342, -219350391, -151874466, -221399919, -90022570, -63892624, -80441153, 143952693, 22150513, -17877846, 208084922, 209533876, 199282852, 28946431, 46895507, -109841246, 208817335, 254839546, -54788427, 138210737, -94182109, -160046898, -243841335, 97943949, 106437630, 32443000, -32273081, -115665080, -257611236, -89503963, 6858125, -91171476, -157980323, -106139384, -150994306, 175237808, 164280223, -127483402, 173787699, -94584308, -116134557, -210457779, -33000660, -109983682, 136658341, 89750297, -165637581, 104488287, -159182529, 47355696, -104681840, -148765655, 12703836, 210946062, 226838746, -11560240, 153753586, 30612560, -171344239, 158232960, -35044863, -10186681, 232338329, 75475309, 37740825, 11228185, 214982269, -32284475, -225050622, 62137910, 54306519, -161991699, 168994569, -36866088, 203279711, -172862596, 80903027, -233280519, 12026443, 11422825, -189187142, 82263523, -238573131, 176583387, -51488018, -51450707, -233094742, 123672453, -173518850, 233686254, -155274811, -251303749, -892420, 179534093, -17944084, -202090547, -133644271, -93833713, -100693677, -20694153, 105044126, 157421899, 36866654, -85670870, 254210531, -176743174, 27316992, -26703029, 207534002, -160884471, -13122417, 168156929, 78313276, 136625629, 52372217, -210148564, 166615958, -181785163, -159870059, 263188892, -67992616, -247149664, 225105347, -74322183, -210625022, 247857120, 221045263, -154900286, -125185375, 85880297, -239919076, 212790757, 185113358, 201667436, 165765082, 34275491, -256567158, 25243601, 215621158, -232884132, 86394229, -64531264, -182723134, -153400015, -264382050, -141629726, -146900939, -185884301, 193251325, -151956563, 85202519, -16068920, 181089617, 62436083, 60440272, -165243795, 222533663, 209114403, 89720897, 175728941, 13779904, -244786127, 138586888, -196924214, -45259073, 127306014, 80717567, 50166089, -61470373, -45450175, -44729827, -184000601, 161923069, -80593594, -182980300, -13590319, -229206348, 184479234, -143779158, 144100230, 1342408, 238446627, -5145335, 253577528, 81101868, 247252369, -205768945, 179094444, 160203477, 35038008, -152252784, 115112023, -165190199, -267002764, -199232771, -30241881, 140042559, 215754142, 46294663, -197513772, 125471385, -115638628, -83744931, -116240781, 267370000, -128321304, -43871568, 220144787, 216528954, 445123, -253232621, -125566344, -185812074, -21764766, 92534859, -40262974, 246756537, -227431258, 193661963, 90992628, 45820279, 260152393, -250828276, -83148257, -3005878, 138655731, -16558697, -65468202, -83527016, 255379775, 146977521, 245276519, 160537713, -120477764, -207457664, 149740721, 41457501, 165774690, -24084874, -124643368, -19332118, 48580230, 108236652, 117992657, -173991930, 58087819, -168723250, 240285917, -86244832, -256846973, -63475278, -76112833, 124776283, -23844807, -116555825, -10406229, 229770025, -172837101, 147646415, -237943558, 150034578, 202842918, 104677142, -158558140, -255552348, 146165742, -140218784, -233012494, 239990650, -21022269, -78922249, 44866796, 115575522, 155307217, -116537894, -18560995, -195957344, -203714106, -247328094, -12154432, 118994200, -204323063, 124462593, 123732606, 231537108, -50939482, -5227291, 19074077, -86032517, -204182772, 160510162, 99175573, 111604151, -112292900, -184524068, -138326884, -37792063, -132864024, 91333570, 219790087, 36935079, 209785739, -263045323, 223825784, 118649884, 185006767, 82113430, 159733379, 165769118, 238143375, -227919079, 244573309, -13652678, -149367440, -135162752, -131148257, -174611766, -179563101, -243916504, 236388979, -28313506, -190638280, 51249159, 172647597, 228345519, 7708245, -191595229, 237371355, -182414099, 136120002, 135033083, 17929913, -47018671, -104742732, 252703376, 263987708, 10363790, -198035899, -112274788, -156194191, 210773650, 15924424, -11332211, 201291167, -127798303, 200110171, 47667091, -116679265, -251051562, 245418091, 87243182, 243365228, -100823208, 232974260, 1492806, -61781783, -107623787, -8062336, 51148075, 262607595, 186735124, 103880595, -62679594, 242596408, 45020163, -140377462, -215808343, -107791913, 82616657, -265927240, -254875266, -4314957, -154747839, 203820486, -197128691, 137943698, 200925393, 265318871, 267580496, -267050038, 50792788, -126766506, -47675391, 22792125, -39284840, -92203735, -85996567, 102243375, -22442292, 165867206, -121069865, -87037879, 14018735, -212794937, -7724372, -63636460, -35676956, -63072566, 212517102, -219844562, -242573336, 70319461, -146081225, 58120660, 233338033, 138831839, 112550296, 207235860, 231654548, -173064259, -186475501, -68652286, 14473444, 243139933, 68551319, -10921957, 178351987, 88132890, -250924296, 135194388, -37560504, 242450499, 252410035, 138116604, -36066615, 147455700, -168152674, -129998708, 43352483, 83655691, 19737357, -123458139, -163176150, 124742912, 238247489, 130077719, 235670866, -213295050, 96486380, -41571261, 257355669, 265070603, 85013326, -151952866, 123096459, -226757040, 17553415, 67495052, -102603546, -178808789, -245714555, -240487063, -169017755, -108206082, 228001852, 110848884, -39844662, -39766857, 39152151, -203957629, 150476211, 266783243, -139428382, 200605399, -58436094, -14310842, -203232885, -130405719},
                new int[]{-17546607, 214071333, -93657289, -165621387, -11839282, 198176602, -64912029, -192474743, -2493976, 99990929, 167486438, -106329152, 184859425, -264773630, 169472755, 41413055, -251096373, -80110364, 30069861, 75320581, 185695928, 195317818, -115725122, -7487907, -158784107, -196023923, -66900235, 161414843, -25937463, 145835332, -202898499, 259829266, -74026668, -157319850, 149881225, 43799905, -123466453, 147330916, -152436728, 221835577, -248543497, 20714983, -12614768, 239832417, -110657465, 43561912, 165071752, -7463783, 78065931, 155976364, 213922644, -217800666, 117615362, 24707363, -185565434, -2496567, 234450588, 210298310, 4529768, -113829319, 147184434, 19829806, -65480417, -223367800, -236359076, 163678294, 125913316, -188623095, 59555496, -111797935, 58175523, -259346726, -33248128, -229144880, -160843897, 27494232, -104453818, 89063257, 249059089, 69323436, 247770901, 1155380, -148019049, -160968762, -52326738, 82325533, -150756244, -104804188, -46356628, 94794403, -261182860, -10420423, 233904773, -80564795, -217303247, 248709484, -217368590, 203569371, 266588872, -160038154, 174084116, -63090368, 130359158, 249120753, 211923649, 64898419, -16491279, -89473178, -179116762, -148644676, -123831028, -78479822, -117028195, -205007240, 147474634, -124632210, 122766610, -31483259, 177986551, 212416299, -173880456, -26259615, 65689126, 262056512, -201886928, -114707242, 177214697, 183136502, 169681484, 89300445, 52105394, -12498419, 127903356, -6374306, 36194910, 255462688, 109178711, 155722896, 74164781, 19458415, 43518348, 29768689, 198946521, 140845308, -265036965, -165240223, -3153151, 151242831, 41276761, -237471486, 37519318, 107074694, -215030646, -3464147, -58802258, 99020863, 213032313, 31235751, -218555771, -37863554, 231126167, -89091450, 17873457, -22810759, 152036250, -258089843, -249909549, -105830340, -121030135, 56984466, 229745302, -43266151, 16449460, 84946278, 78838144, 47264065, -522967, -221520615, -66270632, -253257746, 124993931, 71698073, -179800345, -9879068, -181841274, -216733333, -83486022, 39389160, 92493349, 172404528, 5487456, -196500341, 25118152, -63318215, -71012827, -191687271, 258789989, -47316455, -213910836, -183284934, 96759535, -19262915, -52873957, 106041491, -224910509, -26592332, -152873756, -28605706, 108877934, 42922751, 38500181, 56118455, -242432922, -261959354, -11426682, 132493451, -258308301, -241520608, -235879247, -258549261, 160320330, 204144168, -229333790, -230664067, -254209559, 245681349, -179049065, 261790654, -193316272, 72210889, -229236212, 74540895, 221674964, -40018913, -32341342, -69965461, 123731637, 233836230, 119726263, 246933358, -94021658, -52097607, -10406239, 125734260, -115737123, 5941163, 139255932, -145105600, -193829821, 167740251, -108769677, -42292263, 131405275, -94488790, -182243652, -219764992, 206682974, 43057961, -251186524, -24177736, 30807576, 123925822, -977312, -161625270, 163423897, -118946809, 19676996, 16864825, -247513003, -263782933, 91126968, -197930072, -244550529, -2232143, -231713709, -230791141, -76840135, 22234414, 116549448, 40267838, 166826417, -162653607, 168746048, 146221577, 216339796, -57845269, 13985766, 174960381, 244713552, 132250866, 194165912, 56375268, -192391098, 217736317, -23138312, -40837897, 148109686, -81886357, -213245628, 161819698, 174481764, 200320434, 160713218, 28837628, -36336967, 117182586, -248569392, 253775604, 221105316, 213851844, -150058155, 214073046, 7350551, -120571007, -80617979, -189898994, 51227111, -13466954, 114952286, 132672517, -179105217, 70138185, 88385738, 114926708, -85116697, -95296319, -168266889, 195999185, -84003749, -249418120, -235726658, -207886816, -11693793, 105923530, -90358551, 205189091, 181805713, -5135867, 69330620, -94613491, 10345172, 177136406, 223881958, 205791751, -97769871, -236909138, -1162165, -37959289, 236831358, 135801885, 45942224, 159536698, 160991221, -196495165, -112683826, 234114694, 246786698, -32832684, 85453732, 237587729, 210417625, 97701187, -171891608, -33268255, -71278052, 33950735, 113434539, -163579667, 16482549, 139208106, -133924314, -174985148, 147699372, 242136973, -51223728, 99706118, -249667889, -119022096, 191440014, -124643812, -65369045, -243195741, 101199849, -215324961, -5495160, -102313901, 106679578, 67972208, 150048782, 192562611, -23641643, -196714110, -59965162, -51256959, 145536405, -19500260, 124767517, 95632286, 79251420, -224446048, 85667827, -201627018, 30475498, -260024174, 165039410, -188173717, 161585950, 113560906, -60572913, 54902978, 135580726, -166465510, 147514020, 122455481, 221939011, 49788676, -161920213, -198705087, 56824728, 53677114, -21824892, 211734581, 150254300, 22269437, 15062651, 15872581, 50474197, -103200689, -211868690, 229323751, 134820280, 45454789, -151927405, 224375201, -53443176, -249438829, 49785112, 34597275, 21695084, -103764484, -87614995, -26960575, 92718417, 203227761, 191816676, 57188734, -94058815, 232706170, 230018388, 36657423, 35382336, 233232562, 226830557, 197380490, -51987969, 92219691, -47334803, 131019592, -200679779, -93026917, -265656762, 1901277, -266155336, -43263344, 192736280, 239702174, 228229959, -231427435, 227698144, 145615607, -184131263, -266440106, 149770275, -249784065, 252301281, -174830881, 226987272, 162903342, 239228597, 112318589, -245478676, 121457133, -102744522, 21392804, 80376678, -231685657, 180250745, -264247701, -123596852, -215638565, -252775380, -233211704, -48529937, -120976856, 195556696, 118389478, -6534319, -18057851, 241975837, -187149680}));
    }
}

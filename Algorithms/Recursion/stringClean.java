public String stringClean(String str) {
  if(str == null || str.equals("") || str.length() < 2)
    return str;
  if(str.charAt(0) == str.charAt(1))
    return stringClean(str.substring(1));
  return str.charAt(0) + stringClean(str.substring(1));
}
-----------
/**
(yyzzza)
  y == y -> yzzza
(yzzza)
y == z -> [y] + zzza
(zzza)
z == z -> zza
(zza)
z == z -> za
(za)
z == a -> [z + a]
**/

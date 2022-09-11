# Cagan-Bicakci-Odev3_1
Activity &amp; Fragment Lifecycle &amp; onViewStateRestored and onSaveInstance usage

Bu haftanın 2. ödevine aşağıda linkten erişebilirsiniz :)
<br>
https://github.com/FMSSBilisimAndroid/Cagan-Bicakci-Odev3_2


## Parcelable ve Serializable

Android'de nesneleri yalnızca Activity'lere geçiremeyiz. Bunu yapmak için nesnelere  Serializable ya da Parcalable arayüzleri uygulamalıdır.

Serializable, standart bir Java arabirimidir. Sadece Serializable ekleyerek override methodları ekleyebiliriz. Bu yöntemdeki sorun, reflection kullanılması ve bunun yavaş bir süreç olmasıdır. Bu yüzden çok sayıda geçici nesne oluşmakta ve garbage collectiona neden olabilmektedir. Ancak, Serializable'ın uygulanması kolay bir yöntemdir.

Parcelable işlemi Serializable'dan çok daha hızlıdır. Bunun nedenlerinden biri, sonuç çıktısı için reflection kullanmak yerine serileştirme sürecine açık olmasıdır. Ayrıca, kodun bu amaç için yoğun bir şekilde optimize edilmiş olması da etkilidir.


```
Person person = new Obj("name", "age");

// Passing Person instance via intent
Intent intent = new Intent(FromActivity.this, ToActivity.class);
intent.putExtra("UniqueKey", person);
startActivity(intent);


// Getting Person instance with Serializable
Intent intent = getIntent();
intent.getSerializableExtra("UniqueKey");

// Getting Person instance with Parcalable
Intent intent = getIntent();
intent.getParcelableExtra("UniqueKey");

```

Sonuç olarak;

Serializable - Uygulaması daha kolay bir yöntem
Serializable - Pek çok geçici obje oluşturuyor ve bu da garbage collection'a neden olur

Parcelable - Serializable'dan daha hızlı
Parcelable - Imlement etmesi daha uzun sürer
Parcelable - Intentler arasında arrayler taşınabilir

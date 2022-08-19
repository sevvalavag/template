select * from oyuncular where id=2

select * from roller where oyuncu_id=2

select * from diziler where id=2 or id=3

select Adı from diziler where id=2 or id=3

select Adı,"Yayınlandığı Tarih" from diziler where id=2 or id=3

    insert into oyuncular (id, İsim, "Doğum Tarihi", Boy)
values (3,"Kate Winslet","1975",169)

DELETE
FROM oyuncular
WHERE rowid = 4;

UPDATE oyuncular
set Boy="169"
where İsim="Kate Winslet"

select * from oyuncular ORDER BY Boy desc

select * from oyuncular ORDER BY Boy desc limit 1

select * from oyuncular ORDER BY "Doğum Tarihi" limit 1

select max ("Doğum Tarihi") from oyuncular


select *  -- yıldız her şeyi çek anlamına geliyor
from oyuncular
         JOIN roller on roller.oyuncu_id=oyuncular.id

select oyuncular.İsim,diziler.Adı
from oyuncular
         JOIN roller on roller.oyuncu_id=oyuncular.id
         JOIN diziler on diziler.id=roller.dizi_id

select max("Doğum Tarihi"),diziler.Adı
from oyuncular
         JOIN roller on roller.oyuncu_id=oyuncular.id
         JOIN diziler on diziler.id=roller.dizi_id


select diziler.Adı
from diziler
         JOIN "Ödüller ve Adaylıklar"  on "Ödüller ve Adaylıklar".Dizi_id=diziler.id
where "Ödüller ve Adaylıklar".Sonuç="Kazandı"



